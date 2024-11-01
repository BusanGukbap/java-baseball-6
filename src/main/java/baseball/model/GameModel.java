package baseball.model;

public class GameModel {
    private final Computer computer;
    private final User user;
    private boolean gameEnd;

    public GameModel() {
        this.computer = new Computer();
        this.user = new User();
        this.gameEnd = false;
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}
