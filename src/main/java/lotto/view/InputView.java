package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String enterMoney() {
        printMoneyPrompt();
        return readLine();
    }

    public String enterHitNumbers() {
        printHitNumbersPrompt();
        return readLine();
    }

    public String enterBonusNumber() {
        printBonusPrompt();
        return readLine();
    }

    private void printMoneyPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printHitNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printBonusPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
