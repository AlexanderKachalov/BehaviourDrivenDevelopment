package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import static com.codeborne.selenide.Selenide.*;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1ValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.printBalanceCardOneBeforeTransfer();
        dashboardPage.printBalanceCardTwoBeforeTransfer();
        val replenishmentPage = dashboardPage.depositButtonV1Click();
        val cardInfo = DataHelper.getCardV1Transfer();
        val returnDashboardPage = replenishmentPage.validAmount(cardInfo);
        replenishmentPage.printAmountTransfer(cardInfo);
        returnDashboardPage.dashboardPageVisible();
        returnDashboardPage.printBalanceCardOneAfterTransfer();
        returnDashboardPage.printBalanceCardTwoAfterTransfer();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1NotValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getNotValidAuthInfo();
        val verificationPage = loginPage.notValidLogin(authInfo);
        verificationPage.errorLoginPageVisible();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2ValidLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.printBalanceCardOneBeforeTransfer();
        dashboardPage.printBalanceCardTwoBeforeTransfer();
        val replenishmentPage = dashboardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2Transfer();
        val returnDashboardPage = replenishmentPage.validAmount(cardInfo);
        replenishmentPage.printAmountTransfer(cardInfo);
        returnDashboardPage.dashboardPageVisible();
        returnDashboardPage.printBalanceCardOneAfterTransfer();
        returnDashboardPage.printBalanceCardTwoAfterTransfer();
    }

    @Test
    void shouldTransferMoneyExcessBalance() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getValidAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.printBalanceCardOneBeforeTransfer();
        dashboardPage.printBalanceCardTwoBeforeTransfer();
        val replenishmentPage = dashboardPage.depositButtonV2Click();
        val cardInfo = DataHelper.getCardV2ExcessBalanceTransfer();
        val returnDashboardPage = replenishmentPage.validAmount(cardInfo);
        replenishmentPage.printAmountTransfer(cardInfo);
        returnDashboardPage.dashboardPageVisible();
        returnDashboardPage.printBalanceCardOneAfterTransfer();
        returnDashboardPage.printBalanceCardTwoAfterTransfer();
    }
}
