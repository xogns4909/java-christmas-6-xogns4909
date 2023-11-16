package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.convertor.StringToIntegerConvertor;

public class StringToIntegerTest {

    @ParameterizedTest
    @CsvSource({"10, 10", "0, 0", "-5, -5"})
    @DisplayName("정상적인 숫자 문자열을 정수로 변환")
    void testConvertValidNumbers(String input, int expected) {
        int result = StringToIntegerConvertor.convert(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"a", "1.0", "_"})
    @DisplayName("숫자가 아닌 문자열을 입력했을 때 IllegalArgumentException 발생")
    void testConvertInvalidNumbers(String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> StringToIntegerConvertor.convert(input))
                .withMessage(UtilErrorMessages.NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
    }
}
