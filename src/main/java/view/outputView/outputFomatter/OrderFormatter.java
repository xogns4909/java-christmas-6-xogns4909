package view.outputView.outputFomatter;

import christmas.domain.model.Orders;
import christmas.domain.model.OrderItem;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

public class OrderFormatter {

    public static String formatOrderDetails(Orders orders) {
        StringBuilder builder = new StringBuilder();
        for (OrderItem orderItem : orders.getOrderItems()) {
            builder.append(orderItem.getMenuItem().getName())
                    .append(SPACE.getValue())
                    .append(orderItem.getQuantity())
                    .append(UNIT_PIECE.getMessage())
                    .append("\n");
        }
        return builder.toString();
    }
}