package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Value
public class DashboardPage {
    private SelenideElement pageVisible = $(By.xpath("//*[contains(text(),'Ваши карты')]"));
    private SelenideElement depositButtonV1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement depositButtonV2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");
    private SelenideElement getCardTextOne = $(By.xpath("//*[contains(text(),'0001')]"));
    private SelenideElement getCardTextTwo = $(By.xpath("//*[contains(text(),'0002')]"));

    public DashboardPage () {
        pageVisible.shouldBe(visible);
    }

    public DashboardPage dashboardPageVisible() {
        pageVisible.shouldBe(visible);
        return new DashboardPage();
    }



    public void printBalanceCardOneBeforeTransfer() {
        String cardTextOne = getCardTextOne.text();
        System.out.println("Баланс первой карты до перевода: " + cardTextOne.substring(cardTextOne.indexOf(":") + 2,
                cardTextOne.indexOf(" р.")) + " р.");
    }

    public void printBalanceCardTwoBeforeTransfer() {
        String cardTextTwo = getCardTextTwo.text();
        System.out.println("Баланс второй карты до перевода: " + cardTextTwo.substring(cardTextTwo.indexOf(":") + 2,
                cardTextTwo.indexOf(" р.")) + " р.");
    }

    public void printBalanceCardOneAfterTransfer() {
        String cardTextOne = getCardTextOne.text();
        System.out.println("Баланс первой карты после перевода: " + cardTextOne.substring(cardTextOne.indexOf(":") + 2,
                cardTextOne.indexOf(" р.")) + " р.");
    }

    public void printBalanceCardTwoAfterTransfer() {
        String cardTextTwo = getCardTextTwo.text();
        System.out.println("Баланс второй карты после перевода: " + cardTextTwo.substring(cardTextTwo.indexOf(":") + 2,
                cardTextTwo.indexOf(" р.")) + " р.");
    }

    public ReplenishmentPage depositButtonV1Click() {
        System.out.println("Операция: пополнение первой карты.");
        depositButtonV1.click();
        return new ReplenishmentPage();
    }

    public ReplenishmentPage depositButtonV2Click() {
        System.out.println("Операция: пополнение второй карты.");
        depositButtonV2.click();
        return new ReplenishmentPage();
    }
}