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
}
