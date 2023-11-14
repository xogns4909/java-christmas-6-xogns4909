package christmas.domain.discount;

import christmas.domain.model.MenuItem;
import christmas.domain.model.OrderItem;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

class WeekendDiscountTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("주말 할인 테스트")
    void testCalculateDiscount(Orders orders, ReservationDate date, long expectedDiscount) {
        WeekendDiscount discount = new WeekendDiscount();
        long discountAmount = discount.calculateDiscount(orders, date);

        assertThat(discountAmount).isEqualTo(expectedDiscount);
    }

    private static Stream<Object[]> provideTestCases() {
        return Stream.of(
                new Object[] {
                        new Orders(Arrays.asList(new OrderItem(MenuItem.T_BONE_STEAK, 1))),
                        new ReservationDate(8),
                        2023
                },
                new Object[] {
                        new Orders(Arrays.asList(new OrderItem(MenuItem.T_BONE_STEAK, 1))),
                        new ReservationDate(6),
                        0
                }

        );
    }
}
