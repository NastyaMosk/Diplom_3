package burger.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailField = $x("//input[@type='text' or @name='name']");

    private final SelenideElement passwordField = $x("//input[@type='password' or @name='Пароль']");

    private final SelenideElement loginButton = $x("//button[contains(@class, 'button_button')]");

    private final SelenideElement registerLink = $x("//a[@href='/register']");

    @Step("Заполнить форму авторизации и войти")
    public void login(String email, String password) {
        emailField.shouldBe(visible).setValue(email);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.click();
    }

    @Step("Кликнуть по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        registerLink.shouldBe(visible).click();
    }

    @Step("Проверить видимость кнопки 'Войти'")
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}