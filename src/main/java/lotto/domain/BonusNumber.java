package lotto.domain;

import java.util.Set;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public boolean isBonus(Set<Integer> lottoSet) {
        return lottoSet.contains(this.number);
    }
}
