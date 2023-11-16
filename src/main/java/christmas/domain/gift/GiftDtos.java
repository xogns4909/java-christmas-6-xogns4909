package christmas.domain.gift;

import java.util.List;

public record GiftDtos(List<GiftDto> gifts) {

    public int getTotalGiftValue() {
        return gifts.stream()
                .mapToInt(GiftDto::getTotalValue)
                .sum();
    }
}
