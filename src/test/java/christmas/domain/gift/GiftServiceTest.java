package christmas.domain.gift;

import christmas.domain.model.MenuItem;
import christmas.domain.model.OrderItem;
import christmas.domain.model.Orders;
import christmas.service.GiftService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GiftServiceTest {


    @ParameterizedTest
    @MethodSource("provideTestCase")
    @DisplayName("증정품 가치 계산 테스트")
    void CalculateGiftValue(Orders orders, long expectedGiftValue) {
        GiftService giftService = new GiftService(new StandardGiftPolicy());

        long giftValue = giftService.calculateGiftValue(orders);

        assertThat(giftValue).isEqualTo(expectedGiftValue);
    }

    private static Stream<Object[]> provideTestCase() {
        return Stream.of(
                new Object[]{
                        new Orders(List.of(new OrderItem(MenuItem.T_BONE_STEAK, 3))), 25000L},
                new Object[]{
                        new Orders(List.of(new OrderItem(MenuItem.MUSHROOM_SOUP, 3))), 0L}
        );
    }
}