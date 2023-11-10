package christmas.domain;

import static christmas.PlannerConfig.*;
import static christmas.domain.DomainErrorMessages.*;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<OrderItem> orderItems;

    public Orders(List<OrderItem> orderItems) {
        validateUniqueItems(orderItems);
        validateMaxQuantity(orderItems);
        validateComposeOnlyBeverage(orderItems);
        this.orderItems = new ArrayList<>(orderItems);
    }

    private void validateUniqueItems(List<OrderItem> orderItems) {
        int uniqueItemsCount = (int)orderItems.stream()
                .map(OrderItem::getMenuItem)
                .distinct()
                .count();
        if (uniqueItemsCount < orderItems.size()) {
            throw new IllegalArgumentException(DUPLICATE_MENU_ITEM.getMessage());
        }
    }
    private void validateMaxQuantity(List<OrderItem> orderItems) {
        int sum = orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();

        if (sum > MAXIMUM_ORDER_QUANTITY.getValue()) {
            throw new IllegalArgumentException(ERROR_EXCEED_MAX_QUANTITY.getMessage());
        }
    }

    private void validateComposeOnlyBeverage(List<OrderItem> orderItems) {
        boolean allBeverages = orderItems.stream()
                .allMatch(item -> item.getMenuItem().isBeverage());

        if (allBeverages) {
            throw new IllegalArgumentException(ONLY_BEVERAGES_NOT_ALLOWED.getMessage());
        }
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}