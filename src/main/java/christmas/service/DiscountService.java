package christmas.service;

import christmas.domain.discount.ChristmasDayDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.DiscountDetail;
import christmas.domain.discount.DiscountDetails;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekDayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountService {

    private static final int MINIMUM_DISCOUNT_ORDER_AMOUNT = 10000;
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
        if (!isOrderEligibleForDiscount(orders)) {
            return new DiscountDetails(Collections.emptyList());
        }
        return createDiscountDetails(orders, date);
    }

    private boolean isOrderEligibleForDiscount(Orders orders) {
        return orders.getTotalPrice() > MINIMUM_DISCOUNT_ORDER_AMOUNT;
    }

    private DiscountDetails createDiscountDetails(Orders orders, ReservationDate date) {
        List<DiscountDetail> discountDetails = discounts.stream()
                .map(discount -> createDiscountDetail(discount, orders, date))
                .collect(Collectors.toList());
        return new DiscountDetails(discountDetails);
    }

    private DiscountDetail createDiscountDetail(Discount discount, Orders orders, ReservationDate date) {
        return new DiscountDetail(discount.getType(), discount.calculateDiscount(orders, date));
    }
}