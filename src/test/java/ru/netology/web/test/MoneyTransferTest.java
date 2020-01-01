package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyFromCardTwoToCardOneValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceCardOneBeforeTransfer = dashboardPage.balanceCardOne();
        val replenishmentPage = dashboardPage.depositButtonV1Click();
        val cardInfo = DataHelper.getCardV1Transfer();
        replenishmentPage.validAmount(cardInfo);
        val valueTransfer = replenishmentPage.amountTransfer(cardInfo);
        val balanceCardOneAfterTransfer = dashboardPage.balanceCardOne();
        assertEquals(balanceCardOneBeforeTransfer + valueTransfer, balanceCardOneAfterTransfer);
    }

    @Test
    void shouldTransferMoneyFromCardOneToCardTwoValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceCardTwoBeforeTransfer = dashboardPage.balanceCardTwo();
        val replenishmentPage = dashboardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2Transfer();
        val returnDashboardPage = replenishmentPage.validAmount(cardInfo);
        returnDashboardPage.dashboardPageVisible();
        val valueTransfer = replenishmentPage.amountTransfer(cardInfo);
        val balanceCardTwoAfterTransfer = dashboardPage.balanceCardTwo();
        assertEquals(balanceCardTwoBeforeTransfer + valueTransfer, balanceCardTwoAfterTransfer);
    }

    @Test
    void shouldTransferMoneyExcessBalance() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceCardOneBeforeTransfer = dashboardPage.balanceCardOne();
        val replenishmentPage = dashboardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2ExcessBalanceTransfer();
        val returnDashboardTest = replenishmentPage.excessBalanceTransfer(cardInfo);
        returnDashboardTest.dashboardPageVisible();
        val valueTransfer = replenishmentPage.amountTransfer(cardInfo);
        val balanceCardOneAfterTransfer = dashboardPage.balanceCardOne();
        assertEquals(balanceCardOneBeforeTransfer - valueTransfer, balanceCardOneAfterTransfer);
    }

    @Test
    void shouldErrorPageWhenInputNotValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getNotValidAuthInfo();
        val verificationPage = loginPage.notValidLogin(authInfo);
        val errorLoginPage = verificationPage.errorLoginPageText();
        assertEquals("Ошибка\nОшибка! Неверно указан логин или пароль", verificationPage.errorLoginPageText());
    }

    @Test
    void shouldErrorPageWhenTransferMoneyFromAnyNumberCard() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val replenishmentPage = dashboardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2FromOtherNumberCard();
        val errorPage = replenishmentPage.notValidCardNumber(cardInfo);
        assertEquals("Ошибка", errorPage.errorPageText());
    }
}
