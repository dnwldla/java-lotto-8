package lotto;

import lotto.controller.Game;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputView());
        game.startGame();
    }
}
