package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

@Tag("goose-crystal")
public class SimpleGooseCrystalFactoryTest extends TestBase {



    @Test
    @Description("Наличие ссылки на логотип завода на главной странице")
    void logoLinkMainPageTest() {
        open("/");
        $("[src=\"/local/templates/goose/images/svg/logotype.svg?v2\"]").shouldBe(visible);

    }

    @Test
    @Description("Находим рыбницу по фильтрацией в каталоге")
    void findPlateForFishByFiltersTest() {
        open("/catalog");
        $$(".vi-tools__filter-button-name")
                .findBy(text("Наши предложения "))
                .click();
        $("[title=Новинка]").click();
        $$(".vi-tools__filter-button-name")
                .findBy(text("Коллекция "))
                .click();
        $("[title=Даймонд]").click();
        $(".vi-product__item-title").shouldHave(text("Рыбница, коллекция \"Даймонд\" (бесцветный)"));

    }

    @Test
    @Description("На странице конкретной экскурсии есть 2 другие экскурсии")
    void onIndividualTourPageSholdHasOthersToursTest() {
        open("/ekskursii-na-proizvodstvo");
        $(withTagAndText("b", "Индивидуальная экскурсия «Друзья в гостях у Хрустального Гуся»")).click();
        $$(".vilka-excursion-item").shouldHave(size(2));
    }

    @Test
    @Description("Проверяем адрес магазина в Суздале")
    void validSuzdalStoreAddressTest() {
        open("/about/shops/");
        $(".vi-buy-pick__item-name-default").click();
        $("[data-city=suzdal]").click();
        $$(".vi-buy-city__block-shop-contact")
                .findBy(text("Адрес"))
                .sibling(0)
                .shouldHave(text("601293, Владимирская область, г. Суздаль, ул. Ленина, д.63А Здание Суздальских торговых рядов"));
    }

    @Test
    @Description("Алерт о безуспешной авторизации")
    void successfulRegistrationTest() {
        open("/personal");
        $("[name=USER_LOGIN]").setValue("test");
        $("[name=USER_PASSWORD]").setValue("test");
        $(".btn-primary[value=Войти]").click();
        $(".alert-danger").shouldHave(text("Неверный логин или пароль."));

    }

}
