package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    private final SelenideElement ourOffersFilter = $$(".vi-tools__filter-button-name").findBy(text("Наши предложения"));
    private final SelenideElement novinkaFilter = $("[title=Новинка]");
    private final SelenideElement collectionFilter = $$(".vi-tools__filter-button-name").findBy(text("Коллекция "));
    private final SelenideElement diamondFilter = $("[title=Даймонд]");
    private final SelenideElement productTitle = $(".vi-product__item-title");
    private final SelenideElement firstProductAddToCartButton = $$(".product-item__basket").first();
    private final SelenideElement secondProductAddToCartButton = $$(".product-item__basket").get(1);
    private final SelenideElement cartPopupContinueShoppingButton = $(".vi-popup__footer-buy");
    private final SelenideElement goToCartButton = $(".vi-popup__footer-link[href=\"/personal/cart/\"]");
    private final SelenideElement cartItemCount = $(".animated");

    @Step("Открываем страницу Каталог")
    public void openCatalogPage() {
        open("/catalog");
    }

    @Step("Выбираем Новинка в фильтре Наши предложения")
    public void selectNovinkaFilter() {
        ourOffersFilter.click();
        novinkaFilter.click();
    }

    @Step("Выбираем Даймонд в фильтре Коллекция")
    public void selectDiamondFilter() {
        collectionFilter.click();
        diamondFilter.click();
    }

    @Step("Проверяем, что среди отфильтрованного есть бесцветная рыбница")
    public void checkProductTitle(String title) {
        productTitle.shouldHave(text(title));
    }

    @Step("Добавляем первый товар в корзину")
    public void addFirstProductToCart() {
        firstProductAddToCartButton.click();
    }

    @Step("Добавляем второй товар в корзину")
    public void addSecondProductToCart() {
        secondProductAddToCartButton.click();
    }

    @Step("Нажимаем кнопку 'Продолжить покупки' на попапе")
    public void clickCartPopupContinueShoppingButton() {
        cartPopupContinueShoppingButton.click();
    }

    @Step("Переходим в корзину из попапа")
    public void goToCart() {
        goToCartButton.click();
    }

    @Step("Проверяем, что количество товаров в корзине равно {expectedCount}")
    public void checkCartItemCount(String expectedCount) {
        cartItemCount.shouldHave(text(expectedCount));
    }
}