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

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnExpectedRank(List<Integer> lottoNums, int bonus, Rank expected) {
        Lotto lotto = new Lotto(lottoNums);
        MainNumbers main = new MainNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(String.valueOf(bonus));

        Rank actual = lotto.getRank(main, bonusNumber);

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
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 11, Rank.FIRST),
            Arguments.of(List.of(1, 2, 3, 4, 5, 7), 7, Rank.SECOND),
            Arguments.of(List.of(1, 2, 3, 4, 5, 7), 11, Rank.THIRD),
            Arguments.of(List.of(1, 2, 3, 4, 10, 11), 7, Rank.FOURTH),
            Arguments.of(List.of(1, 2, 3, 10, 11, 12), 7, Rank.FIFTH),
            Arguments.of(List.of(1, 2, 9, 10, 11, 12), 7, Rank.MISS)
        );

    }
}
