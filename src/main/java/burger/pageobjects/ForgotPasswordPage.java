package burger.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage {

    private final SelenideElement loginLink = $x("//a[@href='/login']");

    @Step("Кликнуть 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        loginLink.shouldBe(visible).click();
    }
}