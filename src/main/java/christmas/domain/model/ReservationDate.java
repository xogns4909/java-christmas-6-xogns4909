package christmas.domain.model;

import static christmas.PlannerErrorMessages.*;
import static christmas.PlannerConfig.*;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ReservationDate {

    private int date;
    private DayOfWeek dayOfWeek;

    public ReservationDate(int date) {
        LocalDate localDate = validateDate(date);
        this.date = date;
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    private LocalDate validateDate(int date) {
        try {
            return LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDate() {
        return date;
    }

}
