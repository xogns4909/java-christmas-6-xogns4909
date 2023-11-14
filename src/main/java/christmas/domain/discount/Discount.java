package christmas.domain.discount;

import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;

public interface Discount {
    int calculateDiscount(Orders orders, ReservationDate date);

    DiscountType getType();
}
