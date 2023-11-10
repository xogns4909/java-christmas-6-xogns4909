package christmas.domain;

import java.time.DayOfWeek;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReservationDateTest {

    @ParameterizedTest
    @CsvSource({"1, FRIDAY", "15, FRIDAY", "31, SUNDAY",})
    @DisplayName("Create with correct day")
    void createCorrectDay(int day, DayOfWeek expectedDayOfWeek) {
        ReservationDate reservationDate = new ReservationDate(day);
        assertThat(reservationDate.getDayOfWeek()).isEqualTo(expectedDayOfWeek);
    }

    @ParameterizedTest
    @CsvSource({"0", "32"})
    @DisplayName("Fail on invalid day")
    void failInvalidDay(int day) {
        assertThatThrownBy(() -> new ReservationDate(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessages.INVALID_DATE.getMessage());
    }
}