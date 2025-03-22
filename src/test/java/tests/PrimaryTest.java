package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Credentials;


@Tag("goose-crystal")
public class PrimaryTest extends TestBase {

    public static final String ALERT = "Неверный логин или пароль.";
    public static final String FISH_PLATE_TITLE = "Рыбница, коллекция \"Даймонд\" (бесцветный)";
    public static final String SUZDAL_ADDRESS = "601293, Владимирская область, г. Суздаль, ул. Ленина, д.63А Здание Суздальских торговых рядов";
    public static final String EXPECTED_CART_ITEM_COUNT = "2";

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
        catalogPage.checkProductTitle(FISH_PLATE_TITLE);
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
        storePage.checkSuzdalAddress(SUZDAL_ADDRESS);
    }

    @Test
    @DisplayName("Наличие алерта при безуспешной авторизации")
    void unsuccessfulRegistrationTest() {

        loginPage.openLoginPage();
        loginPage.enterCredentials(Credentials.INVALID_LOGIN.getValue(), Credentials.INVALID_PASSWORD.getValue());
        loginPage.clickLoginButton();
        loginPage.checkAlertText(ALERT);
    }

    @Test
    @DisplayName("Увеличение количества товаров в корзине")
    void increaseItemCountInCartTest() {

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
        catalogPage.waitForFancyboxSlideToDisappear();
        catalogPage.addSecondProductToCart();
        catalogPage.clickCartPopupContinueShoppingButton();
        catalogPage.checkCartItemCount(EXPECTED_CART_ITEM_COUNT);
    }
}
