package christmas.domain;

import christmas.domain.factory.OrderItemFactory;
import christmas.domain.model.OrderItem;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import java.util.stream.Stream;

class OrderItemFactoryTest {


    @ParameterizedTest
    @MethodSource("validInputs")
    @DisplayName("유효한 입력 리스트는 OrderItems를 생성해야 한다")
    void validInputListCreatesOrderItems(List<String> inputs) {
        Assertions.assertThatCode(() -> OrderItemFactory.createOrderItems(inputs))
                .doesNotThrowAnyException();

        List<OrderItem> orderItems = OrderItemFactory.createOrderItems(inputs);
        Assertions.assertThat(orderItems).isNotEmpty();
    }

    static Stream<List<String>> validInputs() {
        return Stream.of(
                List.of("해산물파스타-2", "레드와인-1"),
                List.of("초코케이크-1")
        );
    }


    @ParameterizedTest
    @MethodSource("invalidInputs")
    @DisplayName("유효하지 않은 입력은 예외를 던져야 한다")
    void invalidInputThrowsException(List<String> inputs) {
        Assertions.assertThatThrownBy(() -> OrderItemFactory.createOrderItems(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<String>> invalidInputs() {
        return Stream.of(
                List.of("해산물파스타-two", "레드와인-1"),
                List.of("abc - 1, 123 - 1")
        );
    }
}