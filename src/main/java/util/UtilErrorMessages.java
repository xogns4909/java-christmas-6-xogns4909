package util;

public enum UtilErrorMessages {

    NUMBER_FORMAT_EXCEPTION_MESSAGE("유효한 숫자를 입력해 주세요.");

    private String message;

    UtilErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
