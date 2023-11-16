package view.outputView;

import static christmas.PlannerConfig.*;
public enum PrintMessages {

    WELCOME_MESSAGE(
            String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", EVENT_MONTH.getValue())),
    ASK_FOR_DATE(
            String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
                    , EVENT_MONTH.getValue())),
    ORDER_INPUT_INSTRUCTION(
            "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ERROR("[ERROR]"),
    PREVIEW_EVENT_BENEFITS(("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")),
    UNIT_PIECE("개"),
    ORDER_MENU("주문 메뉴"),
    GIFT_MENU("증정 메뉴"),
    TOTAL_ORDER_PRICE("할인 전 총주문 금액"),

    KRW_CURRENCY_UNIT("원"),

    DISCOUNT_DETAILS("혜택 내역"),

    DISCOUNT_AMOUNT("총혜택 금액"),

    FINAL_PAYMENT_AMOUNT("할인 후 예상 결제 금액"),

    GET_BADGE(String.format("%d월 이벤트 배지",EVENT_MONTH.getValue())),
    NO_DATA("없음");



    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

