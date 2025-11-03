package lotto;

import lotto.domain.LottoConstant;

public class LottoValidator {

    public static final String NUMBER_OUT_OF_RANGE = LottoConstant.toMessage("숫자는 1부터 45 중 하나입니다");
    public static final String NOT_INTEGER = LottoConstant.toMessage("정수가 아닙니다");

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

}
