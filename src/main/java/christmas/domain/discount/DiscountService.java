package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.*;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import christmas.domain.gift.GiftConfig;
import christmas.domain.gift.GiftDto;
import christmas.domain.gift.GiftPolicy;
import christmas.domain.gift.StandardGiftPolicy;
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
        if(orders.getTotalPrice() > MINIMUM_DISCOUNT_ORDER_AMOUNT.getDiscountAmount()) {
            return discounts.stream()
                    .mapToLong(discount -> discount.calculateDiscount(orders, date))
                    .sum();
        }
        return 0L;
    }

}