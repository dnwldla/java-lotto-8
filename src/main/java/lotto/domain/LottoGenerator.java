package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT = 6;

    public static List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
    }

    public static Integer createBonus(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
