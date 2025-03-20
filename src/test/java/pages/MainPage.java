package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement logo = $(".vi-header-logo");

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ищем ссылку на лого завода")
    public void checkLogoIsVisible() {
        logo.shouldBe(visible);
    }

}
