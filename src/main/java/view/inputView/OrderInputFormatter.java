package view.inputView;

import static util.Constants.*;
import static view.inputView.InputErrorMessages.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class OrderInputFormatter {

    private static final Pattern VALID_INPUT_PATTERN = Pattern.compile(
            "([a-zA-Z가-힣]+-\\d+)(,[a-zA-Z가-힣]+-\\d+)*");

    public static List<String> format(String input) {
        if (!VALID_INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(
                  INVALID_FORMAT.getMessage());
        }

        return Arrays.stream(input.split(COMMA.getValue()))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}