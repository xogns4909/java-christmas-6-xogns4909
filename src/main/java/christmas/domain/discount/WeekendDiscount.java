package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.WEEKEND_MAIN_DISCOUNT;

import christmas.domain.OrderItem;
import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.time.DayOfWeek;

public class WeekendDiscount implements Discount {

    @Override
    public long calculateDiscount(Orders orders, ReservationDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (isWeekend(dayOfWeek)) {
            return calculateDiscountAmount(orders);
        }
        return 0L;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.WEEKEND;
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private long calculateDiscountAmount(Orders orders) {
        return orders.getOrderItems().stream()
                .filter(orderItem -> "Main".equals(orderItem.getMenuItem().getCategory()))
                .mapToLong(OrderItem::getQuantity)
                .sum() * WEEKEND_MAIN_DISCOUNT.getDiscountAmount();
    }
}
