package util;

public enum Constants {
    COMMA(","),
    HYPHEN("-");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}