package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.MainNumbers;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.parser.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    void startGame() {
        Money money = enterMoneyInput();
        List<Lotto> lottos = generateLottos(money.getAmount());
        MainNumbers mainNumbers = enterHitNumbers();
        BonusNumber bonusNumber = enterBonusNumber(mainNumbers);

        LottoResult lottoResult= calculateResult(money.getSeeds(),lottos,mainNumbers,bonusNumber);

        OutputView.printResultPrompt();

        double profits = lottoResult.calculateProfits();

        lottoResult.printProgress();

        OutputView.printProfit(profits);

    }

    private LottoResult calculateResult(int seeds, List<Lotto> lottos,MainNumbers mainNumbers,BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult(seeds);

        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(mainNumbers, bonusNumber);

            if (rank != Rank.MISS) {
                lottoResult.add(rank);
            }

        }

        return lottoResult;
    }

    private Money enterMoneyInput() {
        while (true) {
            try {
                String rawMoney = InputView.enterMoney();
                Money money = new Money(rawMoney);
                OutputView.printAmount(money.getAmount());
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

    }

    private List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(LottoGenerator.createLotto()));
        }

        for (Lotto lotto : lottos) {
            lotto.printGeneratedLotto();
        }

        return lottos;
    }

    private MainNumbers enterHitNumbers() {
        while (true) {
            try {
                InputView.enterHitNumbers();

                List<Integer> numbers = LottoNumberParser.parseMainNumbers(readLine());
                MainNumbers mainNumbers = new MainNumbers(numbers);

                return mainNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }


    }

    private BonusNumber enterBonusNumber(MainNumbers mainNumbers) {
        while (true) {
            try {
                InputView.enterBonus();

                BonusNumber bonusNumber = new BonusNumber(readLine());
                WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }

        }


    }


}
