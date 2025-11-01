package lotto.domain;

import lotto.Validator;

public class Money {

    public static final String INVALID_MONEY = LottoConstant.toMessage(String.format("돈의 단위는 %s 으로 나누어 떨어져야 합니다", LottoConstant.PRICE));

    private int amount;
    private final int seeds;

    public Money(String input) {
        int money = Validator.validateInteger(input);
        this.seeds = validateThousandUnit(money);
    }

    public int getAmount() {
        if (amount != 0) {
            return amount;
        }

        amount = seeds / LottoConstant.PRICE;
        return amount;
    }

    public int getSeeds() {
        return seeds;
    }


    private int validateThousandUnit(int money) {

        if (money == 0 || money % LottoConstant.PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }

        return money;
    }

}
