package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.MainNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class InputTest {

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
            .isEqualTo(MainNumbers.NOT_INTEGER);


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
            .isEqualTo(MainNumbers.NUMBER_OUT_OF_RANGE);


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
