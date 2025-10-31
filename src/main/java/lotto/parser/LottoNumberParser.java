package lotto.parser;

import java.util.Arrays;
import java.util.List;
import lotto.Validator;
import lotto.domain.LottoConstant;

public class LottoNumberParser {
    public static final String INVALID_COUNT = LottoConstant.toMessage("총 6개의 숫자를 입력해야 합니다");
    private static final String REGEX = ",";

    public static List<Integer> parseMainNumbers(String input) {
        String[] tokens = input.trim().split(REGEX);

        if (tokens.length != LottoConstant.COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }

        return Arrays.stream(input.trim().split(REGEX))
            .map(Validator::validateInteger)
            .map(Validator::validateRange)
            .sorted()
            .toList();
    }


}
