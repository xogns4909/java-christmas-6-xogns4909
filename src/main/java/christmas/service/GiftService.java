package christmas.service;

import christmas.domain.gift.GiftDto;
import christmas.domain.gift.GiftPolicy;
import christmas.domain.model.Orders;
import java.util.List;

public class GiftService {

    private final GiftPolicy giftPolicy;

    public GiftService(GiftPolicy giftPolicy) {
        this.giftPolicy = giftPolicy;
    }

    public long calculateGiftValue(Orders orders) {
        return applyGiftPolicy(orders).stream()
                .mapToLong(gift -> (long) gift.menuItem().getPrice() * gift.count())
                .sum();
    }

    private List<GiftDto> applyGiftPolicy(Orders orders) {
        return giftPolicy.applyGiftPolicy(orders);
    }
}