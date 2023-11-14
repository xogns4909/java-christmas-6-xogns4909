package christmas.domain.discount;

import christmas.domain.model.MenuItem;
import christmas.domain.model.OrderItem;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class DiscountServiceTest {

    @Test
    void calculateTotalDiscount() {
        Orders orders = new Orders(List.of(new OrderItem(MenuItem.T_BONE_STEAK, 3)));
        ReservationDate date = new ReservationDate(1);

        DiscountDetails expectedDetails = new DiscountDetails(List.of(
                new DiscountDetail(DiscountType.CHRISTMAS_DAY, 1000),
                new DiscountDetail(DiscountType.WEEK_DAY, 0),
                new DiscountDetail(DiscountType.WEEKEND, 6069),
                new DiscountDetail(DiscountType.SPECIAL, 0)
        ));

        DiscountService discountService = new DiscountService();
        DiscountDetails actualDetails = discountService.calculateTotalDiscount(orders, date);

        assertThat(actualDetails).isEqualTo(expectedDetails);
    }
}