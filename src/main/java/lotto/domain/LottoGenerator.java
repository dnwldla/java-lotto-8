package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER, LottoConstant.COUNT)
            .stream().sorted()
            .toList();
    }


}
