package burger.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static final String URL = "https://education-services.ru";

    private final SelenideElement loginAccountButton = $x("//div[contains(@class, 'BurgerConstructor')]//button");
    private final SelenideElement personalAccountButton = $x("//a[@href='/account']");

    // Защищено от проблем кодировки: ищем блоки вкладок по их уникальной внутренней разметке конструктора
    private final SelenideElement bunsTab = $x("//div[span[text()='Булки' or contains(., '┴єыъш')]]");
    private final SelenideElement saucesTab = $x("//div[span[text()='Соусы' or contains(., '╤юєё√')]]");
    private final SelenideElement fillingsTab = $x("//div[span[text()='Начинки' or contains(., '═рўшэъш')]]");
    private final SelenideElement modalOverlay = $(By.className("Modal_modal_overlay__329vW"));

    @Step("Ожидание исчезновения перекрывающего модального окна")
    public void waitForOverlayToDisappear() {
        if (modalOverlay.isDisplayed()) {
            modalOverlay.shouldBe(Condition.disappear, Duration.ofSeconds(5));
        }
    }

    @Step("Кликнуть 'Войти в аккаунт' на главной странице")
    public void clickLoginAccountButton() {
        loginAccountButton.shouldBe(visible).click();
    }

    @Step("Кликнуть по кнопке 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(visible).click();
    }

    @Step("Перейти к разделу 'Булки'")
    public void clickBunsTab() {
        bunsTab.shouldBe(visible).click();
    }

    @Step("Перейти к разделу 'Соусы'")
    public void clickSaucesTab() {
        saucesTab.shouldBe(visible).click();
    }

    @Step("Перейти к разделу 'Начинки'")
    public void clickFillingsTab() {
        fillingsTab.shouldBe(visible).click();
    }

    // Исправлено: проверяем вхождение имени активного подкласса в атрибут class
    @Step("Проверить, что вкладка 'Булки' активна")
    public void verifyBunsTabIsActive() {
        bunsTab.shouldHave(Condition.attributeMatching("class", ".*tab_tab_type_current.*"), Duration.ofSeconds(5));
    }

    @Step("Проверить, что вкладка 'Соусы' активна")
    public void verifySaucesTabIsActive() {
        saucesTab.shouldHave(Condition.attributeMatching("class", ".*tab_tab_type_current.*"), Duration.ofSeconds(5));
    }

    @Step("Проверить, что вкладка 'Начинки' активна")
    public void verifyFillingsTabIsActive() {
        fillingsTab.shouldHave(Condition.attributeMatching("class", ".*tab_tab_type_current.*"), Duration.ofSeconds(5));
    }
}