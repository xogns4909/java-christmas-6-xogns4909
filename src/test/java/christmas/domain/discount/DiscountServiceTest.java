package christmas.domain.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.discount.*;
import christmas.domain.*;

import java.util.List;
import java.util.Arrays;

class DiscountServiceTest {

    @ParameterizedTest
    @CsvSource({"1, 3023", "7, 3623", "25, 6423", "26, 2023"})
    @DisplayName("전체 할인 기능 테스트")
    void testCalculateTotalDiscount(int day, long expectedDiscount) {
        Orders orders = new Orders(createSampleOrderItems());
        ReservationDate date = new ReservationDate(day);
        DiscountService service = new DiscountService();

        long discount = service.calculateTotalDiscount(orders, date);

        assertThat(discount).isEqualTo(expectedDiscount);
    }

    private List<OrderItem> createSampleOrderItems() {
        return Arrays.asList(
                new OrderItem(MenuItem.T_BONE_STEAK, 2),
                new OrderItem(MenuItem.CAESAR_SALAD, 1),
                new OrderItem(MenuItem.CHOCOLATE_CAKE, 1)
        );
    }
}
