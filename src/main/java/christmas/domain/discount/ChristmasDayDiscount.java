package christmas.domain.discount;

import static christmas.PlannerConfig.*;
import static christmas.domain.discount.DiscountConfig.*;


import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import java.time.LocalDate;

public class ChristmasDayDiscount implements Discount {

    private static final LocalDate START_DATE = LocalDate.of(EVENT_YEAR.getValue(),
            EVENT_MONTH.getValue(), EVENT_START_DAY.getValue());
    private static final LocalDate END_DATE = LocalDate.of(EVENT_YEAR.getValue(),
            EVENT_MONTH.getValue(), CHRISTMAS_EVENT_END_DAY.getValue());

    @Override
    public int calculateDiscount(Orders orders, ReservationDate date) {
        LocalDate reservationDate = LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(),
                date.getDate());

        if (!isWithinEventPeriod(reservationDate)) {
            return 0;
        }

        return calculateDiscountAmount(reservationDate);
    }

    @Override
    public DiscountType getType() {
        return DiscountType.CHRISTMAS_DAY;
    }

    private boolean isWithinEventPeriod(LocalDate date) {
        return !date.isBefore(START_DATE) && !date.isAfter(END_DATE);
    }

    private int calculateDiscountAmount(LocalDate date) {
        int daysIntoEvent = date.getDayOfMonth() - START_DATE.getDayOfMonth();
        return CHRISTMAS_BASE_DISCOUNT.getDiscountAmount() + daysIntoEvent
                * DAILY_INCREMENT.getDiscountAmount();
    }
}