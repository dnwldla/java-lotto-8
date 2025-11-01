package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MainNumbers {
    public static final String DUPLICATED_NUMBER = LottoConstant.toMessage("서로 다른 당첨번호를 입력해야 합니다");

    private final List<Integer> numbers;

    public MainNumbers(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
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

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(MainNumbers.DUPLICATED_NUMBER);
        }
    }
}
