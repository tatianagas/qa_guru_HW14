package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Epic("Главная страница")
@Feature("Элементы главной страницы")
@Tag("goose-crystal")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Наличие ссылки на логотип завода на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка видимости логотипа")
    void logoLinkMainPageTest() {

        mainPage.openMainPage();
        mainPage.checkLogoIsVisible();
    }
}