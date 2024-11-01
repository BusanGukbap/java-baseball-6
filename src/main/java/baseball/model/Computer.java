package baseball.model;

import baseball.util.NumberGenerator;

import java.util.List;

public class Computer {

    private List<Integer> number;

    public void generateNumber() {
        this.number = NumberGenerator.generateRandomNumber();
    }

    public List<Integer> getNumber() {
        return number;
    }
}
