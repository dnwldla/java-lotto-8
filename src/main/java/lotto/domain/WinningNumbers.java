package lotto.domain;

public class WinningNumbers {

    private final MainNumbers mainNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(MainNumbers mainNumbers,BonusNumber bonusNumber) {
        validateNumbers(mainNumbers,bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        if (mainNumbers.containsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호에 존재합니다");
        }
    }


}
