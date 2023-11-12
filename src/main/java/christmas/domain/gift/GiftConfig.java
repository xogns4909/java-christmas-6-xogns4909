package christmas.domain.gift;

public enum GiftConfig {
    GIFT_THRESHOLD_AMOUNT(120000);

    private final int value;
    GiftConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
