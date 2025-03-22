package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement loginField = $("[name=USER_LOGIN]"),
            passwordField = $("[name=USER_PASSWORD]"),
            loginButton = $(".btn-primary[value=Войти]"),
            alert = $(".alert-danger");

    @Step("Открываем страницу авторизации")
    public void openLoginPage() {
        open("/personal");
    }

    @Step("Вводим логин и пароль: {login}, {password}")
    public void enterCredentials(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Проверяем алерт с текстом: {expectedText}")
    public void checkAlertText(String expectedText) {
        alert.shouldHave(text(expectedText));
    }
}
