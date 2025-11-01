package lotto.domain;

import java.util.Map;
import lotto.view.OutputView;

public class LottoResult {

    private final int seeds;
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(int seeds) {
        this.seeds = seeds;
        rankCounts=Rank.from();
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


    public void printProgress() {
        rankCounts.entrySet().stream()
            .sorted((o1,o2)-> o1.getKey().getHits()-o2.getKey().getHits())
            .forEach(entry->OutputView.printPrizeResult(entry,entry.getKey().hasBonus()));

    }
}
