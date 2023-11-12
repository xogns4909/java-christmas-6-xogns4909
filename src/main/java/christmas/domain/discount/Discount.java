package christmas.domain.discount;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;

public interface Discount {
    long calculateDiscount(Orders orders, ReservationDate date);

    DiscountType getType();
}
