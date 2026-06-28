package burger.tests;

import burger.pageobjects.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @Description("Переход к разделу конструктора: Соусы")
    public void testConstructorSaucesTabNavigation() {
        Selenide.open(BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.waitForOverlayToDisappear(); // Ожидание скрыто в Page Object
        mainPage.clickSaucesTab();
        mainPage.verifySaucesTabIsActive();   // Проверка и ожидание скрыты в Page Object
    }

    @Test
    @Description("Переход к разделу конструктора: Начинки")
    public void testConstructorFillingsTabNavigation() {
        Selenide.open(BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.waitForOverlayToDisappear();
        mainPage.clickFillingsTab();
        mainPage.verifyFillingsTabIsActive();
    }

    @Test
    @Description("Переход к разделу конструктора: Булки")
    public void testConstructorBunsTabNavigation() {
        Selenide.open(BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.waitForOverlayToDisappear();
        mainPage.clickSaucesTab(); // Переключаемся, так как Булки активны по умолчанию
        mainPage.clickBunsTab();
        mainPage.verifyBunsTabIsActive();
    }
}