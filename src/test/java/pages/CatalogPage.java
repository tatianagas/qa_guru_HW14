package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    private final SelenideElement ourOffersFilter = $$(".vi-tools__filter-button-name").findBy(text("Наши предложения")),
            novinkaFilter = $("[title=Новинка]"),
            collectionFilter = $$(".vi-tools__filter-button-name").findBy(text("Коллекция ")),
            diamondFilter = $("[title=Даймонд]"),
            productTitle = $(".vi-product__item-title"),
            firstProductAddToCartButton = $$(".product-item__basket").first(),
            secondProductAddToCartButton = $$(".product-item__basket").get(1),
            cartPopupContinueShoppingButton = $(".vi-popup__footer-buy"),
            goToCartButton = $(".vi-popup__footer-link[href=\"/personal/cart/\"]"),
            cartItemCount = $(".animated"),
            fancyboxSlide = $(".fancybox-slide");

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
        secondProductAddToCartButton
                .shouldBe(visible, enabled)
                .click(ClickOptions.usingJavaScript());
    }

    @Step("Нажимаем кнопку 'Продолжить покупки' в попапе корзины")
    public void clickCartPopupContinueShoppingButton() {
        cartPopupContinueShoppingButton
                .shouldBe(visible, enabled)
                .click(ClickOptions.usingJavaScript());
    }

    @Step("Переходим в корзину из попапа корзины")
    public void goToCart() {
        goToCartButton.click();
    }

    @Step("Проверяем, что количество товаров в корзине равно {expectedCount}")
    public void checkCartItemCount(String expectedCount) {
        cartItemCount
                .shouldHave(text(expectedCount))
                .shouldBe(visible);
    }

    @Step("Дожидаемся исчезновения перекрывающего элемента (если он есть)")
    public void waitForFancyboxSlideToDisappear() {
        fancyboxSlide.shouldNotBe(visible);
    }
}