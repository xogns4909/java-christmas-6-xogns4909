package christmas;

public enum PlannerConfig {
    MINIMUM_ORDER_QUANTITY(1),

    MAXIMUM_ORDER_QUANTITY(20),
    EVENT_YEAR(2023),
    EVENT_MONTH(12),
    EVENT_START_DAY(1),
    CHRISTMAS_EVENT_END_DAY(25);

    private final int value;

    PlannerConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
