package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.*;

import christmas.domain.OrderItem;
import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.time.DayOfWeek;

public class WeekDayDiscount implements Discount {

    @Override
    public long calculateDiscount(Orders orders, ReservationDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (isWeekday(dayOfWeek)) {
            return calculateDiscountAmount(orders);
        }
        return 0L;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.WEEK_DAY;
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return !dayOfWeek.equals(DayOfWeek.FRIDAY) && !dayOfWeek.equals(DayOfWeek.SATURDAY);
    }
    private long calculateDiscountAmount(Orders orders) {
        return orders.getOrderItems().stream()
                .filter(orderItem -> "Dessert".equals(orderItem.getMenuItem().getCategory()))
                .mapToLong(OrderItem::getQuantity)
                .sum() * WEEKDAY_DESSERT_DISCOUNT.getDiscountAmount();
    }
}
