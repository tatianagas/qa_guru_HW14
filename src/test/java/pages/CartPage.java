package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    private final SelenideElement increaseQuantityButton = $(".basket-item-amount-btn-plus"),
            quantityInput = $("[data-value]");

    @Step("Увеличиваем количество товара в корзине")
    public void increaseItemQuantity() {
        increaseQuantityButton.click();
    }

    @Step("Проверяем, что количество товара в корзине равно {expectedQuantity}")
    public void checkItemQuantity(String expectedQuantity) {
        quantityInput.shouldHave(exactValue(expectedQuantity));
    }
}