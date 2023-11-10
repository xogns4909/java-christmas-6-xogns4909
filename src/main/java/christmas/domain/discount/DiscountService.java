package christmas.domain.discount;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.util.List;

public class DiscountService {

    private final List<Discount> discounts;

    public DiscountService() {
        discounts = List.of(
                new ChristmasDayDiscount(),
                new WeekDayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount()
        );
    }

    public long calculateTotalDiscount(Orders orders, ReservationDate date) {
        return discounts.stream()
                .mapToLong(discount -> discount.calculateDiscount(orders, date))
                .sum();
    }
}