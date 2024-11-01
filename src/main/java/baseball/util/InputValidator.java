package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    public static void validateInput(String input) {
        if (input.length() != 3 || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        List<Integer> numbers = convertInputToList(input);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 3 || numbers.contains(0)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    public static List<Integer> convertInputToList(String input) {
        return input.chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());
    }
}
