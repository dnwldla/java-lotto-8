package lotto.domain;

import lotto.Validator;

public class Money {

    public static final int PRICE = 1000;
    public static final String INVALID_MONEY = LottoConstant.toMessage(String.format("돈의 단위는 %s 으로 나누어 떨어져야 합니다", PRICE));


    private final int amount;

    public Money(String input) {
        this.amount = parseMoney(input);
    }

    public int getAmount() {
        return amount;
    }

    private int parseMoney(String input) {
        int money = Validator.validateInteger(input);

        if (money == 0 || money % PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
        return money / PRICE;
    }

}
