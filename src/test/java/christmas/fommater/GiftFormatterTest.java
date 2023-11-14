package christmas.fommater;

import christmas.domain.MenuItem;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import java.util.Arrays;
import christmas.domain.gift.*;
import view.outputView.outputFomatter.GiftFormatter;

class GiftFormatterTest {

    @ParameterizedTest
    @MethodSource("provideGiftDtosTestCase")
    @DisplayName("선물 형식화 테스트")
    void testFormatGiftDetails(List<GiftDto> giftDtos, String expectedFormat) {
        String formatted = GiftFormatter.formatGiftDetails(giftDtos);
        assertThat(formatted).isEqualTo(expectedFormat);
    }

    static Stream<Arguments> provideGiftDtosTestCase() {
        return Stream.of(
                Arguments.of(Arrays.asList(new GiftDto(MenuItem.CHOCOLATE_CAKE, 1)), "초코케이크 1개\n"),
                Arguments.of(Arrays.asList(new GiftDto(MenuItem.ICE_CREAM, 2)), "아이스크림 2개\n")
        );
    }
}