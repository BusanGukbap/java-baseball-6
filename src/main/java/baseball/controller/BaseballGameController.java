package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.util.InputValidator;

public class BaseballGameController {
        private final BaseballGameService gameService = new BaseballGameService();

        public void run() {
                OutputView.printStartMessage();

                boolean isRunning = true;
                while (isRunning) {
                        gameService.initializeGame();

                        boolean isGameEnd = false;
                        while (!isGameEnd) {
                                String userInput = InputView.getUserInput();
                                try {
                                        String result = gameService.play(userInput);
                                        OutputView.printResult(result);
                                        isGameEnd = gameService.isGameEnd();
                                } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                        return;
                                }
                        }

                        OutputView.printGameEndMessage();
                        isRunning = gameService.askRestart();
                }
        }
}
