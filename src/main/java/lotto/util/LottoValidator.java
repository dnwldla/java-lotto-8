package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoValidator {

    public static final String NUMBER_OUT_OF_RANGE = LottoConstant.toMessage("숫자는 1부터 45 중 하나입니다");
    public static final String NOT_INTEGER = LottoConstant.toMessage("정수가 아닙니다");
    public static final String INVALID_COUNT = LottoConstant.toMessage("총 6개의 숫자를 입력해야 합니다");
    private static final String REGEX = ",";

    public static int validateRange(int number) {
        if (number < LottoConstant.MIN_NUMBER || number > LottoConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        return number;
    }

    public static int validateInteger(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }

        return number;
    }


    public static List<Integer> parseMainNumbers(String input) {
        String[] tokens = input.trim().split(REGEX);

        if (tokens.length != LottoConstant.COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }

        return Arrays.stream(input.trim().split(REGEX))
            .map(LottoValidator::validateInteger)
            .map(LottoValidator::validateRange)
            .sorted()
            .toList();
    }

}
