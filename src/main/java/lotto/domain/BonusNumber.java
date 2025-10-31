package lotto.domain;

import lotto.Validator;

public class BonusNumber {

    private final int number;

    public BonusNumber(String input) {
        this.number = parseNumber(input);
    }

    private Integer parseNumber(String input) {
        int number = Validator.validateInteger(input);
        return Validator.validateRange(number);
    }

    public Integer getNumber() {
        return this.number;
    }
}
