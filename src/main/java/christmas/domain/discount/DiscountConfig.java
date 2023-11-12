package christmas.domain.discount;

public enum DiscountConfig {

    WEEKDAY_DESSERT_DISCOUNT(2023),
    WEEKEND_MAIN_DISCOUNT(2023),
    SPECIAL_EVENT_DISCOUNT(1000),
    CHRISTMAS_BASE_DISCOUNT(1000),
    DAILY_INCREMENT(100),
    SPECIAL_DISCOUNT_AMOUNT(1000),
    MINIMUM_DISCOUNT_ORDER_AMOUNT(10000);
    private final int discountAmount;

    DiscountConfig(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}