package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import baseball.model.GameModel;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameService {
    private GameModel gameModel;

    public void initializeGame() {
        gameModel = new GameModel();
        gameModel.getComputer().generateNumber();
        gameModel.setGameEnd(false);
    }

    public String play(String input) {
        User user = gameModel.getUser();
        user.setNumber(input);

        List<Integer> userNumber = user.getNumber();
        List<Integer> computerNumber = gameModel.getComputer().getNumber();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            gameModel.setGameEnd(true);
            return "3스트라이크";
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append("볼 ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }
        return result.toString().trim();
    }

    public boolean isGameEnd() {
        return gameModel.isGameEnd();
    }

    public boolean askRestart() {
        OutputView.printRestartMessage();
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        return input.equals("1");
    }
}
