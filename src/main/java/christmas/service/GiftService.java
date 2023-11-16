package christmas.service;

import christmas.domain.gift.GiftDto;
import christmas.domain.gift.GiftDtos;
import christmas.domain.gift.GiftPolicy;
import christmas.domain.model.Orders;

public class GiftService {

    private final GiftPolicy giftPolicy;

    public GiftService(GiftPolicy giftPolicy) {
        this.giftPolicy = giftPolicy;
    }

    public GiftDtos calculateGifts(Orders orders) {
        return giftPolicy.applyGiftPolicy(orders);
    }
}