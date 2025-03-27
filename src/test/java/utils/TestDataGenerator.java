package utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private final Faker faker;

    public TestDataGenerator() {
        this.faker = new Faker();
    }

    public String generateRandomLogin() {
        return faker.name().username();
    }

    public String generateRandomPassword() {
        return faker.internet().password();
    }
}
