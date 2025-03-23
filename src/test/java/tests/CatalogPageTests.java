package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CatalogPage;

@Epic("Каталог")
@Feature("Работа с каталогом товаров")
@Tag("goose-crystal")
public class CatalogPageTests extends TestBase {

    public static final String FISH_PLATE_TITLE = "Рыбница, коллекция \"Даймонд\" (бесцветный)";

    CatalogPage catalogPage = new CatalogPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Находим рыбницу с помощью фильтрации в каталоге")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Фильтрация товаров")
    void findPlateForFishByFiltersTest() {

        catalogPage.openCatalogPage();
        catalogPage.selectNovinkaFilter();
        catalogPage.selectDiamondFilter();
        catalogPage.checkProductTitle(FISH_PLATE_TITLE);
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
    @Severity(SeverityLevel.NORMAL)
    @Story("Работа с корзиной")
    void displayItemCountInCartOnCatalogPageTest() {

        catalogPage.openCatalogPage();
        catalogPage.addFirstProductToCart();
        catalogPage.clickCartPopupContinueShoppingButton();
        catalogPage.checkCartItemCount("1");
        catalogPage.addSecondProductToCart();
        catalogPage.clickCartPopupContinueShoppingButton();
        catalogPage.checkCartItemCount("2");
    }
}