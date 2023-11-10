package christmas.domain.discount;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.discount.SpecialDiscount;
import christmas.domain.*;

class SpecialDiscountTest {

    @ParameterizedTest
    @CsvSource({"2023-12-25, 1000", "2023-12-24, 1000", "2023-12-26, 0"})
    @DisplayName("특정 날짜 할인 테스트")
    void testCalculateDiscount(String dateStr, long expectedDiscount) {
        Orders dummyOrders = new Orders(List.of(new OrderItem(MenuItem.BBQ_RIB, 12)));
        LocalDate date = LocalDate.parse(dateStr);
        ReservationDate reservationDate = new ReservationDate(date.getDayOfMonth());
        SpecialDiscount discount = new SpecialDiscount();

        long discountAmount = discount.calculateDiscount(dummyOrders, reservationDate);

        assertThat(discountAmount).isEqualTo(expectedDiscount);
    }
}