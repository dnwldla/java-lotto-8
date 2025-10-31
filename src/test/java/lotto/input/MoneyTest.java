package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Validator;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @Test
    void inputWithValidMoney() {
        String input = "2000";

        Money money = new Money(input);

        assertThat(money.getAmount()).isEqualTo(2);

    }

    @ParameterizedTest
    @ValueSource(strings = {
        "0",
        "1001"
    })
    void inputWithInvalidMoney(String input) {
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new Money(input));

        assertThat(exception.getMessage())
            .isEqualTo(Money.INVALID_MONEY);
    }


    @Test
    void inputWithInvalidString() {
        String input = "?";

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new Money(input));

        assertThat(exception.getMessage())
            .isEqualTo(Validator.NOT_INTEGER);


    }

}
