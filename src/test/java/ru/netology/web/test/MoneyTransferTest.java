package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        dashBoardPage.getBalanceCard();
        val replenishmentPage = dashBoardPage.depositButtonV1Click();
        val cardInfo = DataHelper.getCardV1Transfer();
        replenishmentPage.validAmount(cardInfo);
        dashBoardPage.dashboardPageVisible();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        dashBoardPage.getBalanceCard();
        val replenishmentPage = dashBoardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2Transfer();
        replenishmentPage.validAmount(cardInfo);
        dashBoardPage.dashboardPageVisible();
    }

    @Test
    void shouldTransferMoneyBetweenOwnAnyCard() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        dashBoardPage.getBalanceCard();
        val replenishmentPage = dashBoardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardAnyNumberTransfer();
        replenishmentPage.validAmount(cardInfo);
        dashBoardPage.dashboardPageVisible();
    }
}
