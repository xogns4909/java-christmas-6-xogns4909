package christmas.fommater;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.DisplayName;
import view.inputView.InputErrorMessages;
import view.inputView.OrderInputFormatter;


class OrderInputFormatterTest {

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1", "김치찌개-1,막걸리-2", "스테이크-3"})
    @DisplayName("올바른 포맷의 입력 테스트")
    void ValidFormatTest(String input) {
        List<String> formatted = OrderInputFormatter.format(input);
        Assertions.assertThat(formatted)
                .allSatisfy(
                        item -> Assertions.assertThat(item).containsPattern("[가-힣A-Za-z]+-\\d+"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타,레드와인-1,초코케이크-1", "스테이크--3", " , "})
    @DisplayName("잘못된 입력 예외처리 테스트")
    void isValidFormatTest(String input) {
        Assertions.assertThatThrownBy(() -> OrderInputFormatter.format(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessages.INVALID_FORMAT.getMessage());
    }
}
