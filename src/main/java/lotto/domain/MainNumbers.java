package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Validator;

public class MainNumbers {
    public static final String INVALID_COUNT = LottoConstant.toMessage("총 6개의 숫자를 입력해야 합니다");
    private static final String REGEX = ",";

    private final List<Integer> numbers;

    public MainNumbers(String input) {
        this.numbers = parseNumbers(input);
    }

    public boolean containsBonusNumber(BonusNumber bonus) {
        Set<Integer> set = new HashSet<>(numbers);

        return set.contains(bonus.getNumber());
    }


    private static List<Integer> parseNumbers(String input) {
        String[] tokens = input.trim().split(REGEX);

        if (tokens.length != LottoConstant.COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }

        return Arrays.stream(input.trim().split(REGEX))
            .map(Validator::validateInteger)
            .map(Validator::validateRange).toList();
    }




}
