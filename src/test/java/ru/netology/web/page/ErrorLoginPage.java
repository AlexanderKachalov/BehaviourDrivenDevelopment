package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class ErrorLoginPage {
    private SelenideElement errorLoginPageVisible = $("[data-test-id=error-notification]");

    public String errorLoginPageText() {
        String text = errorLoginPageVisible.getText();
        return text;
    }
}
