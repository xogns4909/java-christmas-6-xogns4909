package christmas.domain.discount;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.*;

class ChristmasDayDiscountTest {

    @ParameterizedTest
    @CsvSource({"1, 1000", "10, 1900", "25, 3400", "26, 0"})
    @DisplayName("크리스마스 디데이 할인 테스트")
    void testCalculateDiscount(int day, long expectedDiscount) {
        Orders dummyOrders = new Orders(List.of(new OrderItem(MenuItem.BBQ_RIB, 12)));
        ReservationDate date = new ReservationDate(day);
        ChristmasDayDiscount discount = new ChristmasDayDiscount();

        long discountAmount = discount.calculateDiscount(dummyOrders, date);

        assertThat(discountAmount).isEqualTo(expectedDiscount);
    }
}