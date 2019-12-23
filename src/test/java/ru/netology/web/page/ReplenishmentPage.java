package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class ReplenishmentPage {
    private SelenideElement amountToReplenish = $("[data-test-id='amount'] input");
    private SelenideElement cardNumberField = $(".input__control");
    private SelenideElement cardNumberInput = $("[data-test-id='from'] input");
    private SelenideElement replenishButton = $("[data-test-id='action-transfer']");

    public DashboardPage validAmount(DataHelper.ReplenishmentAmount replenishmentAmount) {
        amountToReplenish.setValue(replenishmentAmount.getTransferAmount());
        cardNumberField.click();
        cardNumberInput.setValue(replenishmentAmount.getNumberCard());
        replenishButton.click();
        return new DashboardPage();
    }

}