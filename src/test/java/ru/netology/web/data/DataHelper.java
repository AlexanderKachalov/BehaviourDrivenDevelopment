package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getNotValidAuthInfo() {
        return new AuthInfo("petya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class ReplenishmentAmount {
        private String transferAmount;
        private String numberCard;
    }

    public static ReplenishmentAmount getCardV1Transfer() {
        return new ReplenishmentAmount("200", "5559000000000002");
    }

    public static ReplenishmentAmount getCardV2Transfer() {
        return new ReplenishmentAmount("200", "5559000000000001");
    }


    public static ReplenishmentAmount getCardV2ExcessBalanceTransfer() {
        return new ReplenishmentAmount("20000", "5559000000000001");
    }
}
