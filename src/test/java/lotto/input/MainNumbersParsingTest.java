package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.util.LottoValidator;
import lotto.util.LottoNumberParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MainNumbersParsingTest {

    @Test
    void inputWithValidString() {
        String input = "1,2,3,4,5,6";

        assertDoesNotThrow(() -> LottoNumberParser.parseMainNumbers(input));

    }

    @Test
    void inputWithInvalidString() {
        String input = "1,2,3!,4,5,6";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> LottoNumberParser.parseMainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(LottoValidator.NOT_INTEGER);


    }

    @ParameterizedTest
    @ValueSource(strings = {
        "-1,2,3,4,5,6",
        "0,1,2,3,4,5",
        "1,2,3,4,5,46"
    })
    void inputWithNegativeNumber(String input) {
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> LottoNumberParser.parseMainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(LottoValidator.NUMBER_OUT_OF_RANGE);


    }


    @Test
    void inputWithInvalidSize() {
        String input = "1,2,3,4,5";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> LottoNumberParser.parseMainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(LottoNumberParser.INVALID_COUNT);
    }

}
