package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
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
        return new ReplenishmentAmount("200", "0000000000000002");
    }

    public static ReplenishmentAmount getCardV2Transfer() {
        return new ReplenishmentAmount("200", "0000000000000001");
    }

    public static ReplenishmentAmount getCardAnyNumberTransfer() {
        return new ReplenishmentAmount("300", "1234567789990098");
    }

    public static ReplenishmentAmount getCardV2ExcessBalanceTransfer() {
        return new ReplenishmentAmount("2000000", "0000000000000001");
    }
}
