package christmas.domain.discount;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;

public interface Discount {
    int calculateDiscount(Orders orders, ReservationDate date);

    DiscountType getType();
}
