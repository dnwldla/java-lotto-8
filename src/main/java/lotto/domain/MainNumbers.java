package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
        int hit=0;

        for (Integer lottoNumber:lottoNumbers){
            for (Integer mainNumber:numbers){
                if (lottoNumber==mainNumber){
                    hit++;
                    break;
                }
            }
        }

        return hit;
    }
}
