package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class ErrorLoginPage {
    private SelenideElement errorPageVisible = $("[data-test-id=error-notification]");

    public ErrorLoginPage errorLoginPageVisible() {
        errorPageVisible.shouldBe(visible);
        return new ErrorLoginPage();
    }
}
