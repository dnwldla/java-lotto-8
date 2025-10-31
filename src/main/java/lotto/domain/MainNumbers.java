package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MainNumbers {
    private final List<Integer> numbers;

    public MainNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsBonusNumber(BonusNumber bonus) {
        Set<Integer> set = new HashSet<>(numbers);

        return set.contains(bonus.getNumber());
    }

    public int getHits(List<Integer> lottoNumbers) {
        long hit=IntStream.range(0, numbers.size())
            .filter(i -> numbers.get(i).equals(lottoNumbers.get(i)))
            .count();

        return (int)hit;
    }
}
