package christmas.domain.discount;

public enum DiscountType {
    CHRISTMAS_DAY("크리스마스 디데이 할인"),
    WEEK_DAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인");

    private final String message;


    DiscountType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}