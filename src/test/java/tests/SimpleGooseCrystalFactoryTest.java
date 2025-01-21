package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("goose-crystal")
public class SimpleGooseCrystalFactoryTest extends TestBase {

    private static final String TEXT = "test";
    private static final String ALERT = "Неверный логин или пароль.";



    @Test
    @DisplayName("Наличие ссылки на логотип завода на главной странице")
    void logoLinkMainPageTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу ", () -> {
            open("/");
        });
        step("Ищем ссылку на лого завода ", () -> {
            $("[src=\"/local/templates/goose/images/svg/logotype.svg?v2\"]").shouldBe(visible);
        });

    }

    @Test
    @DisplayName("Находим рыбницу с помощью фильтрации в каталоге")
    void findPlateForFishByFiltersTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Каталог ", () -> {
            open("/catalog");
        });

        step("Выбираем Новинка в фильтре Наши предложения ", () -> {
            $$(".vi-tools__filter-button-name")
                    .findBy(text("Наши предложения "))
                    .click();
            $("[title=Новинка]").click();
        });

        step("Выбираем Даймонд в фильтре Коллекция ", () -> {
            $$(".vi-tools__filter-button-name")
                    .findBy(text("Коллекция "))
                    .click();
            $("[title=Даймонд]").click();
        });

        step("Проверяем, что среди отфильтрованного есть бесцветная рыбница ", () -> {
            $(".vi-product__item-title").shouldHave(text("Рыбница, коллекция \"Даймонд\" (бесцветный)"));
        });

    }

    @Test
    @DisplayName("На странице конкретной экскурсии есть инф.блоки 2 других экскурсий")
    void onIndividualTourPageSholdHasOthersToursTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу экскурсий ", () -> {
            open("/ekskursii-na-proizvodstvo");
        });

        step("Выбираем индивидуальную экскурсию ", () -> {
            $(withTagAndText("b", "Индивидуальная экскурсия «Друзья в гостях у Хрустального Гуся»")).click();
        });

        step("Проверяем наличие блоков двух других экскурсий на странице ", () -> {
            $$(".vilka-excursion-item").shouldHave(size(2));
        });


    }

    @Test
    @DisplayName("Проверяем корректность адреса магазина в Суздале")
    void validSuzdalStoreAddressTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Магазины ", () -> {
            open("/about/shops/");
        });

        step("Выбираем Суздаль из выпадающего списка ", () -> {
            $(".vi-buy-pick__item-name-default").click();
            $("[data-city=suzdal]").click();
        });

        step("Проверяем адрес магазина в Суздадале ", () -> {
            $$(".vi-buy-city__block-shop-contact")
                    .findBy(text("Адрес"))
                    .sibling(0)
                    .shouldHave(text("601293, Владимирская область, г. Суздаль, ул. Ленина, д.63А Здание Суздальских торговых рядов"));
        });

    }

    @Test
    @DisplayName("Наличие алерта при безуспешной авторизации")
    void unsuccessfulRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Заходим в ЛК ", () -> {
            open("/personal");
        });

        step("Вводим " + TEXT + " в поля логина и пароля", () -> {
            $("[name=USER_LOGIN]").setValue(TEXT);
            $("[name=USER_PASSWORD]").setValue(TEXT);
        });

        step("Подтверждаем действия ", () -> {
            $(".btn-primary[value=Войти]").click();
        });

        step("Проверяем алерт и текст его содержимого " + ALERT , () -> {
            $(".alert-danger").shouldHave(text(ALERT));
        });


    }

}
