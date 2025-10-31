package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.MainNumbers;
import lotto.domain.Rank;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public Rank getRank(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        int hits = mainNumbers.getHits(numbers);
        boolean hasBonus = bonusNumber.isBonus(toSet());

        return Rank.getRank(hits, hasBonus);
    }

    private Set<Integer> toSet() {
        return new HashSet<>(numbers);
    }

}
