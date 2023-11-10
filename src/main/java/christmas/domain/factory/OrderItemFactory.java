package christmas.domain.factory;

import static util.Constants.*;

import christmas.domain.MenuItem;
import christmas.domain.OrderItem;
import java.util.List;
import java.util.stream.Collectors;
import util.Constants;
import util.convertor.StringToIntegerConvertor;

public class OrderItemFactory {

    public static List<OrderItem> createOrderItems(List<String> inputs) {
        return inputs.stream()
                .map(OrderItemFactory::createOrderItem)
                .collect(Collectors.toList());
    }

    private static OrderItem createOrderItem(String input) {
        String[] parts = input.split(HYPHEN.getValue());
        MenuItem menuItem = MenuItem.fromString(parts[0].trim());
        int quantity = StringToIntegerConvertor.convert(parts[1].trim());
        return new OrderItem(menuItem, quantity);
    }
}