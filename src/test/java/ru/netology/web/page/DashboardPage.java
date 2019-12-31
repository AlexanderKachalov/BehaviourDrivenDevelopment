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

    public int balanceCardOne() {
        String cardTextOne = getCardTextOne.text();
        return Integer.parseInt(cardTextOne.substring(cardTextOne.indexOf(":") + 2,
                cardTextOne.indexOf(" р.")));
    }

    public int balanceCardTwo() {
        String cardTextTwo = getCardTextTwo.text();
        return Integer.parseInt(cardTextTwo.substring(cardTextTwo.indexOf(":") + 2,
                cardTextTwo.indexOf(" р.")));
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