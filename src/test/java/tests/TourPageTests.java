package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TourPage;

@Epic("Экскурсии")
@Feature("Информация об экскурсиях")
@Tag("goose-crystal")
public class TourPageTests extends TestBase {

    TourPage tourPage = new TourPage();

    @Test
    @DisplayName("На странице конкретной экскурсии есть инф.блоки 2 других экскурсий")
    @Severity(SeverityLevel.MINOR)
    @Story("Отображение информации об экскурсиях")
    void onIndividualTourPageShouldHasOthersToursTest() {

        tourPage.openTourPage();
        tourPage.selectIndividualTour();
        tourPage.checkNumberOfTours(2);
    }
}