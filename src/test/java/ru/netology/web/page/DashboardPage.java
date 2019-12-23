package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

@Value
public class DashboardPage {
    private SelenideElement pageVisible = $("[data-test-id='dashboard]");
    private SelenideElement depositButtonV1 = $$("[data-test-id='action-deposit']").first();
    private SelenideElement depositButtonV2 = $$("[data-test-id='action-deposit']").last();
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");
    private SelenideElement getCardTextOne = $$(".list__item").first();
    private SelenideElement getCardTextTwo = $$(".list__item").last();

    public DashboardPage dashboardPageVisible() {
        pageVisible.shouldBe(visible);
        return new DashboardPage();
    }



    public void getBalanceCard() {
        String cardTextOne = getCardTextOne.text();
        String cardTextTwo = getCardTextTwo.text();
        System.out.println("Баланс первой карты: " + cardTextOne.substring(cardTextOne.indexOf(":") + 2,
                cardTextOne.indexOf(" р.")) + " р.");
        System.out.println("Баланс второй карты: " + cardTextOne.substring(cardTextTwo.indexOf(":") + 2,
                cardTextOne.indexOf(" р.")) + " р.");
    }

    public ReplenishmentPage depositButtonV1Click() {
        depositButtonV1.click();
        return new ReplenishmentPage();
    }

    public ReplenishmentPage depositButtonV2Click() {
        depositButtonV2.click();
        return new ReplenishmentPage();
    }
}