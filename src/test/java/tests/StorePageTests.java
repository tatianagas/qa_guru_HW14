package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StorePage;

@Epic("Магазины")
@Feature("Информация о магазинах")
@Tag("goose-crystal")
public class StorePageTests extends TestBase {

    public static final String SUZDAL_ADDRESS = "601293, Владимирская область, г. Суздаль, ул. Ленина, д.63А Здание Суздальских торговых рядов";

    StorePage storePage = new StorePage();

    @Test
    @DisplayName("Проверяем корректность адреса магазина в Суздале")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка адресов магазинов")
    void validSuzdalStoreAddressTest() {
        storePage.openStorePage();
        storePage.selectSuzdalCity();
        storePage.checkSuzdalAddress(SUZDAL_ADDRESS);
    }
}