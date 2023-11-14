package christmas.domain.model;

import static christmas.PlannerErrorMessages.*;

import christmas.PlannerConfig;
public class OrderItem {

    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        validateMenuItem(menuItem);
        validateQuantity(quantity);
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    private void validateMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < PlannerConfig.MINIMUM_ORDER_QUANTITY.getValue()) {
            throw new IllegalArgumentException(INVALID_MENU_QUANTITY.getMessage());
        }
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}