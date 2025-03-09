package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TourPage {
    private final ElementsCollection tours = $$(".vilka-excursion-item");

    @Step("Открываем страницу экскурсий")
    public void openTourPage() {
        open("/ekskursii-na-proizvodstvo");
    }

    @Step("Выбираем индивидуальную экскурсию")
    public void selectIndividualTour() {
        $(withTagAndText("b", "Индивидуальная экскурсия «Друзья в гостях у Хрустального Гуся»")).click();
    }

    @Step("Проверяем наличие блоков двух других экскурсий на странице")
    public void checkNumberOfTours(int expectedSize) {
        tours.shouldHave(size(expectedSize));
    }
}
