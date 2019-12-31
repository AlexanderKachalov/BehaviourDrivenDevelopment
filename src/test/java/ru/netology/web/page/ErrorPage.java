package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ErrorPage {
    private SelenideElement errorTransferPageVisible = $$(".notification__title").findBy(text("Ошибка"));
    private SelenideElement errorTransferPageText = $(".notification__title");

    public ErrorPage() {
        errorTransferPageVisible.shouldBe(visible);
    }

    public String errorPageText() {
        return errorTransferPageText.getText();
    }
}
