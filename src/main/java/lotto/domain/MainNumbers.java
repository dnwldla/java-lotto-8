package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class MainNumbers {
    private final List<Integer> numbers;

    public MainNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsBonusNumber(BonusNumber bonus) {
        Set<Integer> set = new HashSet<>(numbers);

        return set.contains(bonus.getNumber());
    }

    public int getHits(Lotto lotto) {
        int hit=0;
        for (int i=0;i<numbers.size();i++) {
            if (numbers.get(i)==lotto.getNumbers().get(i)) {
                hit++;
            }
        }
        return hit;
    }
}
