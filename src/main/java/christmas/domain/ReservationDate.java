package christmas.domain;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;

public class ReservationDate {
    private static final int YEAR = 2023;
    private static final Month MONTH = Month.DECEMBER;
    private int date;
    private DayOfWeek dayOfWeek;

    public ReservationDate(int date) {
        LocalDate localDate = validateDate(date);
        this.date = date;
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    private LocalDate validateDate(int date) {
        try {
            return LocalDate.of(YEAR, MONTH, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(DomainErrorMessages.INVALID_DATE.getMessage());
        }
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

}
