package christmas.controller;

public enum ControllerErrorMessages {

    INVALID_INPUT(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    ControllerErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }