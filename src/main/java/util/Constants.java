package util;

public enum Constants {
    COMMA(","),
    HYPHEN("-"),
    SECTION_START("<"),
    SECTION_END(">"),

    SPACE(" "),

    COLON(":");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}