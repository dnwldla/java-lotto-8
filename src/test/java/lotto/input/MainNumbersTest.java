package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Validator;
import lotto.domain.MainNumbers;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MainNumbersTest {

    @Test
    void inputWithValidString() {
        String input = "1,2,3,4,5,6";

        assertDoesNotThrow(() -> new MainNumbers(input));

    }

    @Test
    void inputWithInvalidString() {
        String input = "1,2,3!,4,5,6";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new MainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(Validator.NOT_INTEGER);


    }

    @ParameterizedTest
    @ValueSource(strings = {
        "-1,2,3,4,5,6",
        "0,1,2,3,4,5",
        "1,2,3,4,5,46"
    })
    void inputWithNegativeNumber(String input) {
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new MainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(WinningNumbers.NUMBER_OUT_OF_RANGE);


    }


    @Test
    void inputWithInvalidSize() {
        String input = "1,2,3,4,5";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new MainNumbers(input));

        assertThat(exception.getMessage())
            .isEqualTo(MainNumbers.INVALID_COUNT);
    }

}
