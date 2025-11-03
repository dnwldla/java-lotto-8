package lotto.domain;

import lotto.util.LottoConstant;

public class WinningNumbers {

    public static final String ALREADY_EXIST = LottoConstant.toMessage("보너스 번호가 로또 번호에 이미 존재합니다");

    private final MainNumbers mainNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        validateNumbers(mainNumbers, bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        if (mainNumbers.containsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(WinningNumbers.ALREADY_EXIST);
        }
    }


}
