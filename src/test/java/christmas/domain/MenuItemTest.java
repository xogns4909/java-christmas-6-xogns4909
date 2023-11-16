package christmas.domain;

import christmas.domain.model.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MenuItemTest {

    @ParameterizedTest
    @ValueSource(strings = {"coke","cake","rice"})
    @DisplayName("없는 메뉴 예외처리 테스트")
    void invalidMenuThrows(String value) {

        assertThatThrownBy(() -> MenuItem.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No enum constant");
    }

    @ParameterizedTest
    @ValueSource(strings = {"TAPAS", "RED_WINE", "SEAFOOD_PASTA"})
    @DisplayName("메뉴아이템 생성 테스트")
    void createMenuTest(String validMenuItemName) {
        MenuItem menuItem = MenuItem.valueOf(validMenuItemName);

        assertThat(menuItem).isNotNull();
        assertThat(menuItem.name()).isEqualTo(validMenuItemName);
    }
}