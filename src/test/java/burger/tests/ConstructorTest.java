package burger.tests;

import burger.pageobjects.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.$x;

public class ConstructorTest extends BaseTest {

    private void waitForOverlayToDisappear() {
        // Ждем, пока исчезнет перекрывающее модальное окно, если оно появляется
        $x("//div[contains(@class, 'Modal_modal_overlay')]").shouldBe(Condition.disappear, Duration.ofSeconds(5));
    }

    @Test
    @Description("Переход к разделу конструктора: Соусы")
    public void testConstructorSaucesTabNavigation() {
        Selenide.open(BASE_URL);
        waitForOverlayToDisappear(); // Ожидание перед кликом

        MainPage mainPage = new MainPage();
        mainPage.clickSaucesTab();

        new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(3))
                .until(driver -> mainPage.getActiveTabName().contains("Соусы"));

        Assert.assertTrue("Таб 'Соусы' должен стать активным", mainPage.getActiveTabName().contains("Соусы"));
    }

    @Test
    @Description("Переход к разделу конструктора: Начинки")
    public void testConstructorFillingsTabNavigation() {
        Selenide.open(BASE_URL);
        waitForOverlayToDisappear(); // Ожидание перед кликом

        MainPage mainPage = new MainPage();
        mainPage.clickFillingsTab();

        new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(3))
                .until(driver -> mainPage.getActiveTabName().contains("Начинки"));

        Assert.assertTrue("Таб 'Начинки' должен стать активным", mainPage.getActiveTabName().contains("Начинки"));
    }

    @Test
    @Description("Переход к разделу конструктора: Булки")
    public void testConstructorBunsTabNavigation() {
        Selenide.open(BASE_URL);
        waitForOverlayToDisappear(); // Ожидание перед кликом

        MainPage mainPage = new MainPage();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(3))
                .until(driver -> mainPage.getActiveTabName().contains("Булки"));

        Assert.assertTrue("Таб 'Булки' должен стать активным", mainPage.getActiveTabName().contains("Булки"));
    }
}