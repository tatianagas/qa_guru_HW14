package utils;

public enum Credentials {
    VALID_LOGIN("tratata"),
    VALID_PASSWORD("123456"),
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
