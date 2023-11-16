package christmas.domain.badge;

import christmas.domain.model.Badge;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeTest {

    @ParameterizedTest
    @CsvSource({"-1, NONE", "4999, NONE", "5000, STAR", "9999, STAR", "10000, TREE", "19999, TREE",
            "20000, SANTA",
            "25000, SANTA"
    })
    @DisplayName("주문 금액에 따른 배지 반환 검증")
    void testBadgeDetermination(int totalAmount, Badge expectedBadge) {
        assertThat(Badge.getBadgeForAmount(totalAmount)).isEqualTo(expectedBadge);
    }
}