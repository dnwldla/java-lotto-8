package lotto.domain;

import java.util.Arrays;
import java.util.Map.Entry;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int hits;
    private final boolean hasBonus;
    private final long prize;

    Rank(int hits, boolean hasBonus, long prize) {
        this.hits = hits;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank getRank(int hits, boolean hasBonus) {
        return Arrays.stream(Rank.values())
            .filter((rank) -> rank.hits == hits && rank.hasBonus == hasBonus)
            .findFirst()
            .orElse(MISS);
    }


    public static long getProfits(Entry<Rank, Integer> entry) {
        int amount = entry.getValue();
        Rank rank = entry.getKey();

        return (long) amount * rank.prize;
    }
}
