package lotto.domain;

import java.util.Set;
import lotto.util.LottoValidator;

public class BonusNumber {

    private final int number;

    public BonusNumber(String input) {
        this.number = parseNumber(input);
    }

    private Integer parseNumber(String input) {
        int number = LottoValidator.validateInteger(input);
        return LottoValidator.validateRange(number);
    }

    public Integer getNumber() {
        return this.number;
    }

    public boolean isBonus(Set<Integer> lottoSet) {
        return lottoSet.contains(this.number);
    }
}
