package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReplenishmentPage {
    private SelenideElement pageVisible = $(By.xpath("//*[contains(text(),'Пополнение карты')]"));;
    private SelenideElement amountToReplenish = $("[data-test-id='amount'] input");
    private SelenideElement cardNumberField = $(".input__control");
    private SelenideElement cardNumberInput = $("[data-test-id='from'] input");
    private SelenideElement replenishButton = $("[data-test-id='action-transfer']");

    public ReplenishmentPage() {
        pageVisible.shouldBe(visible);
    }

    public DashboardPage validAmount(DataHelper.ReplenishmentAmount replenishmentAmount) {
        amountToReplenish.setValue(replenishmentAmount.getTransferAmount());
        cardNumberField.click();
        cardNumberInput.setValue(replenishmentAmount.getNumberCard());
        replenishButton.click();
        return new DashboardPage();
    }

    public int amountTransfer(DataHelper.ReplenishmentAmount amount) {
        return Integer.parseInt(amount.getTransferAmount());
    }

    public ErrorPage notValidCardNumber(DataHelper.ReplenishmentAmount replenishmentAmount) {
        amountToReplenish.setValue(replenishmentAmount.getTransferAmount());
        cardNumberField.click();
        cardNumberInput.setValue(replenishmentAmount.getNumberCard());
        replenishButton.click();
        return new ErrorPage();
    }

    public DashboardPage excessBalanceTransfer(DataHelper.ReplenishmentAmount replenishmentAmount) {
        amountToReplenish.setValue(replenishmentAmount.getTransferAmount());
        cardNumberField.click();
        cardNumberInput.setValue(replenishmentAmount.getNumberCard());
        replenishButton.click();
        return new DashboardPage();
    }

}