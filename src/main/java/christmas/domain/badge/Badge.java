package christmas.domain.badge;

import java.util.Arrays;

public enum Badge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별"),
    NONE(-1, "없음");
    private final int threshold;
    private final String displayName;

    Badge(int threshold, String displayName) {
        this.threshold = threshold;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Badge getBadgeForAmount(int totalAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> totalAmount >= badge.threshold)
                .findFirst()
                .orElse(NONE);
    }
}