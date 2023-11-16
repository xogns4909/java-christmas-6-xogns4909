package christmas.domain.gift;

import christmas.domain.model.MenuItem;

public record GiftDto(MenuItem menuItem, int count) {

    public int getTotalValue() {
        return menuItem.getPrice() * count;
    }

}
