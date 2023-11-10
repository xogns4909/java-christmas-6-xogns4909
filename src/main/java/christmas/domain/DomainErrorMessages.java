package christmas.domain;

enum  DomainErrorMessages {
    INVALID_DATE("유효하지 않은 날짜입니다");

    private final String message;

    DomainErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
