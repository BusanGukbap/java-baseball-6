package baseball.model;

import baseball.util.InputValidator;

import java.util.List;

public class User {

    private List<Integer> number;

    public void setNumber(String input) {
        InputValidator.validateInput(input);
        this.number = InputValidator.convertInputToList(input);
    }

    public List<Integer> getNumber() {
        return number;
    }
}
