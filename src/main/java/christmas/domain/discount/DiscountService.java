package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.*;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public DiscountDetails calculateTotalDiscount(Orders orders, ReservationDate date) {
        if (orders.getTotalPrice() > MINIMUM_DISCOUNT_ORDER_AMOUNT.getDiscountAmount()) {
            List<DiscountDetail> discountDetails = discounts.stream()
                    .map(discount -> new DiscountDetail(discount.getType(), discount.calculateDiscount(orders, date)))
                    .collect(Collectors.toList());
            return new DiscountDetails(discountDetails);
        }
        return new DiscountDetails(Collections.emptyList());
    }
}