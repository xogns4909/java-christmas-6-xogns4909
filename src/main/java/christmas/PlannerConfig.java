package christmas;

public enum PlannerConfig {
    MINIMUM_ORDER_QUANTITY(1),

    MAXIMUM_ORDER_QUANTITY(20);

    private final int value;

    PlannerConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
