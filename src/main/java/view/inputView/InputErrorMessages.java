package view.inputView;

public enum InputErrorMessages {

    INVALID_FORMAT("입력 형식이 잘못되었습니다. 올바른 형식: '메뉴명-수량,메뉴명-수량,...'");

    private final String message;

    InputErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
