package christmas.domain.discount;

import static christmas.PlannerConfig.*;
import static christmas.domain.discount.DiscountConfig.*;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount implements Discount {

    private static final LocalDate CHRISTMAS = LocalDate.of(EVENT_YEAR.getValue(),
            EVENT_MONTH.getValue(),  CHRISTMAS_EVENT_END_DAY.getValue());

    @Override
    public long calculateDiscount(Orders orders, ReservationDate date) {
        LocalDate reservationDate = LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(),
                date.getDate());

        if (isSpecialDay(reservationDate)) {
            return SPECIAL_DISCOUNT_AMOUNT.getDiscountAmount();
        }
        return 0L;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.SPECIAL;
    }

    private boolean isSpecialDay(LocalDate date) {
        return date.equals(CHRISTMAS) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
