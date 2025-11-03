package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.LottoValidator;
import lotto.domain.BonusNumber;
import lotto.domain.MainNumbers;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @Test
    void inputWithValidString() {
        String input = "6";

        assertDoesNotThrow(() -> new BonusNumber(input));

    }

    @Test
    void inputWithDuplicateNumber() {
        String input = "6";

        List<Integer> mainNumbers = List.of(1,2,3,4,5,6);

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(new MainNumbers(mainNumbers), new BonusNumber(input)));

        assertThat(exception.getMessage())
            .isEqualTo(WinningNumbers.ALREADY_EXIST);

    }

    @Test
    void inputWithInvalidString() {
        String input = "3!";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));

        assertThat(exception.getMessage())
            .isEqualTo(LottoValidator.NOT_INTEGER);

    }


    @ParameterizedTest
    @ValueSource(strings = {
        "0",
        "-1",
        "46"
    })
    void inputWithOutOfRangeNumber(String input) {
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));

        assertThat(exception.getMessage())
            .isEqualTo(LottoValidator.NUMBER_OUT_OF_RANGE);
    }

}
