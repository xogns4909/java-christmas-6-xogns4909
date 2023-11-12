package christmas.domain.gift;

import christmas.domain.MenuItem;
import christmas.domain.OrderItem;
import christmas.domain.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StandardGiftPolicyTest {

    private final StandardGiftPolicy giftPolicy = new StandardGiftPolicy();

    @ParameterizedTest
    @MethodSource("ordersWithGift")
    @DisplayName("샴페인 증정 테스트")
    void  WithGift(Orders orders) {
        List<GiftDto> gifts = giftPolicy.applyGiftPolicy(orders);
        assertThat(gifts).containsExactly(new GiftDto(MenuItem.CHAMPAGNE, 1));
    }

    private static Stream<Orders> ordersWithGift() {
        return Stream.of(
                new Orders(List.of(new OrderItem(MenuItem.T_BONE_STEAK, 10))),
                new Orders(List.of(new OrderItem(MenuItem.BBQ_RIB, 3),
                        new OrderItem(MenuItem.CAESAR_SALAD, 5)))
        );
    }

    @ParameterizedTest
    @MethodSource("ordersWithoutGift")
    @DisplayName("증정품 없음 테스트")
    void WithoutGift(Orders orders) {
        List<GiftDto> gifts = giftPolicy.applyGiftPolicy(orders);
        assertThat(gifts).isEmpty();
    }

    private static Stream<Orders> ordersWithoutGift() {
        return Stream.of(
                new Orders(List.of(new OrderItem(MenuItem.T_BONE_STEAK, 1))),
                new Orders(List.of(new OrderItem(MenuItem.CAESAR_SALAD, 2),
                        new OrderItem(MenuItem.ICE_CREAM, 3)))
        );
    }
}