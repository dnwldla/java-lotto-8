package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MainNumbers;
import lotto.domain.Rank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {
    private final Lotto LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnExpectedRank(MainNumbers mainNumbers, BonusNumber bonusNumber, Rank expected) {
        Rank actual = LOTTO.getRank(mainNumbers, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calculateProfitBasedOnResult() {

        LottoResult result = new LottoResult(8000);

        result.add(Rank.FIFTH);

        assertThat(result.calculateProfits()).isEqualTo(62.5);

    }

    private static Stream<Arguments> cases() {
        return Stream.of(
            Arguments.of(
                new MainNumbers(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(11),
                Rank.FIRST
            ),
            Arguments.of(
                new MainNumbers(List.of(1, 2, 3, 4, 5, 7)),
                new BonusNumber(6),
                Rank.SECOND
            ),
            Arguments.of(
                new MainNumbers(List.of(1, 2, 3, 4, 5, 7)),
                new BonusNumber(11),
                Rank.THIRD
            ),
            Arguments.of(
                new MainNumbers(List.of(1, 2, 3, 4, 10, 11)),
                new BonusNumber(7),
                Rank.FOURTH
            ),
            Arguments.of(
                new MainNumbers(List.of(1, 2, 3, 10, 11, 12)),
                new BonusNumber(7),
                Rank.FIFTH
            ),
            Arguments.of(
                new MainNumbers(List.of(1, 2, 9, 10, 11, 12)),
                new BonusNumber(7),
                Rank.MISS
            )
        );
    }
}
