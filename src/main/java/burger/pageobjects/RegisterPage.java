package burger.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    private final SelenideElement nameField = $x("(//input[@type='text'])[1]");

    private final SelenideElement emailField = $x("(//input[@type='text'])[2]");

    private final SelenideElement passwordField = $x("//input[@type='password']");

    private final SelenideElement registerButton = $x("//form//button");

    private final SelenideElement loginLink = $x("//a[@href='/login']");

    private final SelenideElement passwordError = $x("//p[contains(@class, 'input__error')]");

    @Step("Заполнить поля регистрации и нажать кнопку")
    public void register(String name, String email, String password) {
        nameField.shouldBe(visible).setValue(name);
        emailField.shouldBe(visible).setValue(email);
        passwordField.shouldBe(visible).setValue(password);
        registerButton.click();
    }

    @Step("Кликнуть по ссылке 'Войти' на странице регистрации")
    public void clickLoginLink() {
        loginLink.shouldBe(visible).click();
    }

    @Step("Проверить, отображается ли ошибка некорректного пароля")
    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }
}