package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.MainNumbers;
import lotto.domain.Rank;
import lotto.view.OutputView;

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
        Set<Integer> set=new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다");
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

    public void printGeneratedLotto(){
        OutputView.printGeneratedLotto(numbers);
    }

    private Set<Integer> toSet() {
        return new HashSet<>(numbers);
    }

}
