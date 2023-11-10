package christmas.domain.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;


import christmas.domain.*;
import java.util.Arrays;
import java.util.stream.Stream;

class WeekDayDiscountTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("평일 할인 테스트")
    void testCalculateDiscount(Orders orders, ReservationDate date, long expectedDiscount) {
        WeekDayDiscount discount = new WeekDayDiscount();
        long discountAmount = discount.calculateDiscount(orders, date);

        assertThat(discountAmount).isEqualTo(expectedDiscount);
    }

    private static Stream<Object[]> provideTestCases() {
        return Stream.of(
                new Object[] {
                        new Orders(Arrays.asList(new OrderItem(MenuItem.CHOCOLATE_CAKE, 1))),
                        new ReservationDate(5),
                        2023
                },
                new Object[] {
                        new Orders(Arrays.asList(new OrderItem(MenuItem.T_BONE_STEAK, 1))),
                        new ReservationDate(9),
                        0
                }
        );
    }
}