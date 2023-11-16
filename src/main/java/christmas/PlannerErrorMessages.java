package christmas;

public enum PlannerErrorMessages {
    INVALID_DATE("유효하지 않은 날짜입니다"),

    INVALID_MENU_QUANTITY("음식은 1개이상 주문해야 됩니다"),
    INVALID_MENU("메뉴에 존재하지 않는 메뉴입니다."),
    DUPLICATE_MENU_ITEM("주문은 중복된 메뉴를 포함할 수 없습니다."),
    ERROR_EXCEED_MAX_QUANTITY("주문 가능한 총 수량은 20개를 초과할 수 없습니다."),

    ONLY_BEVERAGES_NOT_ALLOWED("주문은 음료만으로 구성될 수 없습니다."),

    INVALID_MENU_INPUT(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE_INPUT(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");




    private final String message;

    PlannerErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
