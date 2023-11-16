package christmas.fommater;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import christmas.domain.discount.*;
import view.outputView.outputFomatter.DiscountFormatter;

class DiscountFormatterTest {

    @ParameterizedTest
    @MethodSource("provideDiscountDetailsTestCase")
    @DisplayName("할인 포맷 테스트")
    void formatDiscountDetailsTest(DiscountDetails discountDetails, String expectedFormat) {
        String formatted = DiscountFormatter.formatDiscountDetails(discountDetails);
        assertThat(formatted).isEqualTo(expectedFormat);
    }

    static Stream<Arguments> provideDiscountDetailsTestCase() {
        return Stream.of(
                Arguments.of(new DiscountDetails(
                                List.of(new DiscountDetail(DiscountType.CHRISTMAS_DAY, 1000))),
                        "크리스마스 디데이 할인: -1,000원\n"),
                Arguments.of(new DiscountDetails(
                                List.of(new DiscountDetail(DiscountType.WEEK_DAY, 500)))
                        , "평일 할인: -500원\n")
        );
    }
}