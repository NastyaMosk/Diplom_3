package burger.tests;

import burger.pageobjects.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @Description("Переходы к разделам конструктора: Булки, Соусы, Начинки")
    public void testConstructorTabsNavigation() {

        Selenide.open(BASE_URL);
        MainPage mainPage = new MainPage();


        mainPage.clickSaucesTab();

        Selenide.sleep(500);
        Assert.assertTrue("Таб 'Соусы' должен стать активным", mainPage.getActiveTabName().contains("Соусы"));


        mainPage.clickFillingsTab();
        Selenide.sleep(500);
        Assert.assertTrue("Таб 'Начинки' должен стать активным", mainPage.getActiveTabName().contains("Начинки"));


        mainPage.clickBunsTab();
        Selenide.sleep(500);
        Assert.assertTrue("Таб 'Булки' должен стать активным", mainPage.getActiveTabName().contains("Булки"));
    }
}