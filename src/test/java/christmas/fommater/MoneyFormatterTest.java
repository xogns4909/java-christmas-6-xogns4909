package christmas.fommater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import view.outputView.outputFomatter.MoneyFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyFormatterTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000, 123456, 1234567})
    @DisplayName("금액 형식화 테스트")
    void testFormatMoney(int amount) {
        String formatted = MoneyFormatter.formatMoney(amount);

        assertThat(formatted).endsWith("원");
        assertThat(formatted).matches("\\d{1,3}(,\\d{3})*원");
    }
}
