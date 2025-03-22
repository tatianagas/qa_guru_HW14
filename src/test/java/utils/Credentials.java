package utils;

public enum Credentials {
    INVALID_LOGIN("test"),
    INVALID_PASSWORD("test");

    private final String value;

    Credentials(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
