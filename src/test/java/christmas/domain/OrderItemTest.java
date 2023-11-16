package christmas.domain;

import christmas.PlannerErrorMessages;
import christmas.domain.model.MenuItem;
import christmas.domain.model.OrderItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


import static christmas.PlannerErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderItemTest {

    @ParameterizedTest
    @CsvSource({"TAPAS, 1", "RED_WINE, 3", " CHOCOLATE_CAKE, 2"})
    @DisplayName("주문 아이템 생성 테스트")
    void testValidOrderItemCreation(MenuItem menuItem, int quantity) {
        OrderItem orderItem = new OrderItem(menuItem, quantity);
        assertThat(orderItem).isNotNull();
        assertThat(orderItem.getMenuItem()).isEqualTo(menuItem);
        assertThat(orderItem.getQuantity()).isEqualTo(quantity);
    }

    @ParameterizedTest
    @CsvSource({"TAPAS, 0", "RED_WINE, -1"})
    @DisplayName("주문시 갯수 예외처리 테스트")
    void testInvalidOrderItemQuantity(MenuItem menuItem, int quantity) {
        assertThatThrownBy(() -> new OrderItem(menuItem, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MENU_QUANTITY.getMessage());
    }
}