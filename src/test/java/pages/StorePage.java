package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StorePage {
    private final SelenideElement cityDropdown = $(".vi-buy-pick__item-name-default"),
            suzdalCity = $("[data-city=suzdal]"),
            suzdalAddress = $$(".vi-buy-city__block-shop-contact")
                    .findBy(text("Адрес"))
                    .sibling(0);

    @Step("Открываем страницу Магазины")
    public void openStorePage() {
        open("/about/shops/");
    }

    @Step("Выбираем Суздаль из выпадающего списка")
    public void selectSuzdalCity() {
        cityDropdown.click();
        suzdalCity.click();
    }

    @Step("Проверяем адрес магазина в Суздале")
    public void checkSuzdalAddress(String expectedAddress) {
        suzdalAddress.shouldHave(text(expectedAddress));
    }
}
