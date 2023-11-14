package view.inputView;

import christmas.domain.model.OrderItem;
import christmas.domain.model.Orders;
import christmas.domain.factory.OrderItemFactory;
import java.util.List;
import util.convertor.StringToIntegerConvertor;
public class InputView {

    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public int inputReservationDate(){
        String date = input.input();
        return StringToIntegerConvertor.convert(date);
    }

    public Orders inputOrderItems() {
        String inputOrder = input.input();
        List<String> orders = OrderInputFormatter.format(inputOrder);
        List<OrderItem> orderItems = OrderItemFactory.createOrderItems(orders);
        return new Orders(orderItems);
    }
}