package christmas.fommater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import java.util.List;
import christmas.domain.*;
import view.outputView.outputFomatter.OrderFormatter;

class OrderFormatterTest {

    @ParameterizedTest
    @MethodSource("provideOrdersTestCase")
    @DisplayName("주문 포맷 테스트")
    void formatOrderDetailsTest(Orders order, String expectedFormat) {
        String formatted = OrderFormatter.formatOrderDetails(order);
        assertThat(formatted).isEqualTo(expectedFormat);
    }

    static Stream<Arguments> provideOrdersTestCase() {
        return Stream.of(
                Arguments.of(new Orders(List.of(new OrderItem(MenuItem.MUSHROOM_SOUP, 2))),
                        "양송이수프 2개\n"),
                Arguments.of(new Orders(List.of(new OrderItem(MenuItem.TAPAS, 1))), "타파스 1개\n")
        );
    }
}