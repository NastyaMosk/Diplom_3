package burger.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static final String URL = "https://stellarburgers.education-services.ru/";


    private final SelenideElement loginAccountButton = $x("//div[contains(@class, 'BurgerConstructor')]//button");


    private final SelenideElement personalAccountButton = $x("//a[@href='/account']");

    private final SelenideElement bunsTab = $x("(//div[contains(@class, 'tab_tab')])[1]");
    private final SelenideElement saucesTab = $x("(//div[contains(@class, 'tab_tab')])[2]");
    private final SelenideElement fillingsTab = $x("(//div[contains(@class, 'tab_tab')])[3]");

    private final SelenideElement activeTab = $x("//div[contains(@class,'tab_tab_type_current')]");

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

    @Step("Получить текст активной вкладки")
    public String getActiveTabName() {
        return activeTab.shouldBe(visible).getText();
    }
}