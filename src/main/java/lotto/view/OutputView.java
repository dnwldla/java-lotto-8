package lotto.view;

import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Rank;

public class OutputView {

    public static void printPrizeResult(Entry<Rank, Integer> entry, boolean hasBonus) {
        Rank rank = entry.getKey();
        int count = entry.getValue();
        if (hasBonus) {
            printBonusResult(rank, count);
        }else{
            System.out.printf("%d개 일치 ( %,d원 ) - %d개\n", rank.getHits(), rank.getPrize(), count);

        }

    }

    public static void printGeneratedLotto(List<Integer> lotto){
        System.out.println(lotto.toString());

    }

    private static void printBonusResult(Rank rank, int count) {
        System.out.printf("%d개 일치, 보너스 볼 일치 ( %,d원 ) - %d개\n", rank.getHits(), rank.getPrize(),
            count);

    }
}
