package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainNumbers {
    public static final String INVALID_COUNT = "총 6개의 숫자를 입력해야 합니다";
    public static final String NUMBER_OUT_OF_RANGE = "숫자는 1부터 45 중 하나입니다";
    public static final String NOT_INTEGER = "정수가 아닙니다";

    private static final String REGEX = ",";

    private final List<Integer> numbers;

    public MainNumbers(String input) {
        this.numbers = parseNumbers(input);
    }

    public boolean containsBonusNumber(BonusNumber bonus) {
        Set<Integer> set = new HashSet<>(numbers);

        return set.contains(bonus.getNumber());
    }


    public static List<Integer> parseNumbers(String input) {
        String[] tokens = input.trim().split(REGEX);

        if (tokens.length != LottoConstant.COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }

        return Arrays.stream(input.trim().split(REGEX))
            .map(MainNumbers::validateInteger)
            .map(MainNumbers::validateRange).toList();
    }


    private static int validateRange(int number) {
        if (number < LottoConstant.MIN_NUMBER || number > LottoConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        return number;
    }

    private static int validateInteger(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }

        return number;
    }

}
