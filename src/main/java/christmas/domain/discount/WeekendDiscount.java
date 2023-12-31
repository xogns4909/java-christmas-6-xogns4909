package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.WEEKEND_MAIN_DISCOUNT;

import christmas.domain.model.OrderItem;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import java.time.DayOfWeek;

public class WeekendDiscount implements Discount {

    @Override
    public int calculateDiscount(Orders orders, ReservationDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (isWeekend(dayOfWeek)) {
            return calculateDiscountAmount(orders);
        }
        return 0;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.WEEKEND;
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private int calculateDiscountAmount(Orders orders) {
        return (int)orders.getOrderItems().stream()
                .filter(orderItem -> "Main".equals(orderItem.getMenuItem().getCategory()))
                .mapToLong(OrderItem::getQuantity)
                .sum() * WEEKEND_MAIN_DISCOUNT.getDiscountAmount();
    }
}
