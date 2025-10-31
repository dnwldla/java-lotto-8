package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int seeds;
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoResult(int seeds) {
        this.seeds = seeds;
    }

    public void add(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public double calculateProfits() {
        long gain = 0;

        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            gain += Rank.getProfits(entry);
        }

        return (double) (gain * 100) / seeds;
    }


}
