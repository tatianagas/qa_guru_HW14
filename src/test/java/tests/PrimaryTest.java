package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Credentials;

public class PrimaryTest extends TestBase {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    TourPage tourPage = new TourPage();
    StorePage storePage = new StorePage();
    LoginPage loginPage = new LoginPage();

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
    void onIndividualTourPageSholdHasOthersToursTest() {

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
}
