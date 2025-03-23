package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Epic("Авторизация")
@Feature("Проверка авторизации")
@Tag("goose-crystal")
public class LoginPageTests extends TestBase {

    public static final String ALERT = "Неверный логин или пароль.";

    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @Test
    @DisplayName("Наличие алерта при безуспешной авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Обработка ошибок авторизации")
    void unsuccessfulRegistrationTest() {

        String invalidLogin = faker.name().username();
        String invalidPassword = faker.internet().password();

        loginPage.openLoginPage();
        loginPage.enterCredentials(invalidLogin, invalidPassword);
        loginPage.clickLoginButton();
        loginPage.checkAlertText(ALERT);
    }
}