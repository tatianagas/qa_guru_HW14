package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Credentials;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@Tag("goose-crystal")
public class PrimaryTest extends TestBase {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    TourPage tourPage = new TourPage();
    StorePage storePage = new StorePage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Наличие ссылки на логотип завода на главной странице")
    void logoLinkMainPageTest() {

        mainPage.openMainPage();
        mainPage.checkLogoIsVisible();
    }

    @Test
    @DisplayName("Находим рыбницу с помощью фильтрации в каталоге")
    void findPlateForFishByFiltersTest() {

        catalogPage.openCatalogPage();
        catalogPage.selectNovinkaFilter();
        catalogPage.selectDiamondFilter();
        catalogPage.checkProductTitle("Рыбница, коллекция \"Даймонд\" (бесцветный)");
    }

    @Test
    @DisplayName("На странице конкретной экскурсии есть инф.блоки 2 других экскурсий")
    void onIndividualTourPageShouldHasOthersToursTest() {

        tourPage.openTourPage();
        tourPage.selectIndividualTour();
        tourPage.checkNumberOfTours(2);
    }

    @Test
    @DisplayName("Проверяем корректность адреса магазина в Суздале")
    void validSuzdalStoreAddressTest() {

        storePage.openStorePage();
        storePage.selectSuzdalCity();
        storePage.checkSuzdalAddress("601293, Владимирская область, г. Суздаль, ул. Ленина, д.63А Здание Суздальских торговых рядов");
    }

    @Test
    @DisplayName("Наличие алерта при безуспешной авторизации")
    void unsuccessfulRegistrationTest() {

        loginPage.openLoginPage();
        loginPage.enterCredentials(Credentials.INVALID_LOGIN.getValue(), Credentials.INVALID_PASSWORD.getValue());
        loginPage.clickLoginButton();
        loginPage.checkAlertText(TestData.ALERT);
    }

    @Test
    @DisplayName("Увеличение количества одинаковых товаров в корзине")
    void increaseSameItemCountInCartTest() {
        catalogPage.openCatalogPage();
        catalogPage.addFirstProductToCart();
        catalogPage.goToCart();
        cartPage.increaseItemQuantity();
        cartPage.checkItemQuantity("2");
    }

    @Test
    @DisplayName("Отображение количества товаров в корзине на странице каталога")
    void displayItemCountInCartOnCatalogPageTest() {
        catalogPage.openCatalogPage();
        catalogPage.addFirstProductToCart();
        catalogPage.clickCartPopupContinueShoppingButton();
        catalogPage.addSecondProductToCart();
        catalogPage.clickCartPopupContinueShoppingButton();
        catalogPage.checkCartItemCount("2");
    }
}
