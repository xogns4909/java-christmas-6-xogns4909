package christmas.domain.gift;

import static christmas.domain.gift.GiftConfig.*;

import christmas.domain.MenuItem;
import christmas.domain.Orders;
import java.util.ArrayList;
import java.util.List;

public class StandardGiftPolicy implements GiftPolicy {

    @Override
    public List<GiftDto> applyGiftPolicy(Orders orders) {
        int totalPrice = orders.getTotalPrice();
        List<GiftDto> giftDtos = new ArrayList<>();
        if (totalPrice >= GIFT_THRESHOLD_AMOUNT.getValue()) {
            giftDtos.add(new GiftDto(MenuItem.CHAMPAGNE, 1));
        }
        return giftDtos;
    }
}
