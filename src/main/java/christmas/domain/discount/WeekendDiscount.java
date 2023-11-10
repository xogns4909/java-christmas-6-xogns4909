package christmas.domain.discount;

import static christmas.domain.discount.DiscountConfig.WEEKDAY_DESSERT_DISCOUNT;
import static christmas.domain.discount.DiscountConfig.WEEKEND_MAIN_DISCOUNT;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.time.DayOfWeek;

public class WeekendDiscount implements Discount{

    @Override
    public long calculateDiscount(Orders orders, ReservationDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (isWeekend(dayOfWeek)) {
            return calculateDiscountAmount(orders);
        }
        return 0L;
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private long calculateDiscountAmount(Orders orders) {
        long count = orders.getOrderItems().stream()
                .filter(orderItem -> "Main".equals(orderItem.getMenuItem().getCategory()))
                .count();

        return count * WEEKEND_MAIN_DISCOUNT.getDiscountAmount();
    }
}
