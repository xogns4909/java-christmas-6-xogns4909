package christmas.domain;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

class OrdersTest {


    @ParameterizedTest
    @MethodSource("validOrderItemList")
    @DisplayName("주문 목록으로 Orders 생성")
    void createOrdersTest(List<OrderItem> orderItems) {
        Orders orders = new Orders(orderItems);
        assertThat(orders.getOrderItems()).hasSameElementsAs(orderItems);
    }

    static Stream<List<OrderItem>> validOrderItemList() {
        return Stream.of(
                Arrays.asList(
                        new OrderItem(MenuItem.TAPAS, 1),
                        new OrderItem(MenuItem.RED_WINE, 2)
                ),
                Arrays.asList(
                        new OrderItem(MenuItem.BBQ_RIB, 3),
                        new OrderItem(MenuItem.CHAMPAGNE, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidOrderItemList")
    @DisplayName("중복된 메뉴 아이템이 예외 발생")
    void DuplicateItemsExceptionTest(List<OrderItem> orderItems) {
        assertThatThrownBy(() -> new Orders(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessages.DUPLICATE_MENU_ITEM.getMessage());
    }

    static Stream<List<OrderItem>> invalidOrderItemList() {
        return Stream.of(
                Arrays.asList(
                        new OrderItem(MenuItem.TAPAS, 1),
                        new OrderItem(MenuItem.TAPAS, 2)
                ),
                Arrays.asList(
                        new OrderItem(MenuItem.RED_WINE, 1),
                        new OrderItem(MenuItem.RED_WINE, 1)
                )
        );
    }
}