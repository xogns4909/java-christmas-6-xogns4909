package christmas.domain.discount;

import static christmas.PlannerConfig.*;
import static christmas.domain.discount.DiscountConfig.*;


import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import java.time.LocalDate;
import java.time.Month;

public class ChristmasDayDiscount implements Discount {

    private static final LocalDate START_DATE = LocalDate.of(EVENT_YEAR.getValue(),
            EVENT_MONTH.getValue(), EVENT_START_DAY.getValue());
    private static final LocalDate END_DATE = LocalDate.of(EVENT_YEAR.getValue(),
            EVENT_MONTH.getValue(), CHRISTMAS_EVENT_END_DAY.getValue());

    @Override
    public long calculateDiscount(Orders orders, ReservationDate date) {
        LocalDate reservationDate = LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(),
                date.getDate());

        if (!isWithinEventPeriod(reservationDate)) {
            return 0L;
        }

        return calculateDiscountAmount(reservationDate);
    }

    private boolean isWithinEventPeriod(LocalDate date) {
        return !date.isBefore(START_DATE) && !date.isAfter(END_DATE);
    }

    private long calculateDiscountAmount(LocalDate date) {
        int daysIntoEvent = date.getDayOfMonth() - START_DATE.getDayOfMonth();
        return CHRISTMAS_BASE_DISCOUNT.getDiscountAmount() + ((long) daysIntoEvent
                * DAILY_INCREMENT.getDiscountAmount());
    }
}