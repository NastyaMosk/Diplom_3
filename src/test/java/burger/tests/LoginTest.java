package burger.tests;

import burger.api.User;
import burger.api.UserClient;
import burger.pageobjects.MainPage;
import burger.pageobjects.LoginPage;
import burger.pageobjects.RegisterPage;
import burger.pageobjects.ForgotPasswordPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;

public class LoginTest extends BaseTest {
    private User user;

    @Before
    public void prepareTestData() {

        String email = "qa_diplom_" + UUID.randomUUID() + "@yandex.ru";
        user = new User(email, "password123", "QA_User");

        Response response = UserClient.createUser(user);
        accessToken = response.path("accessToken");
    }

    @Test
    @Description("Вход по кнопке 'Войти в аккаунт' на главной")
    public void testLoginFromMainPageButton() {
        Selenide.open(BASE_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickLoginAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        Selenide.webdriver().shouldHave(WebDriverConditions.url(BASE_URL));
    }

    @Test
    @Description("Вход через кнопку 'Личный кабинет'")
    public void testLoginFromPersonalAccountButton() {
        Selenide.open(BASE_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        Selenide.webdriver().shouldHave(WebDriverConditions.url(BASE_URL));
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void testLoginFromRegisterForm() {

        Selenide.open(BASE_URL + "register");
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickLoginLink();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        Selenide.webdriver().shouldHave(WebDriverConditions.url(BASE_URL));
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void testLoginFromForgotPasswordForm() {

        Selenide.open(BASE_URL + "forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.clickLoginLink();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        Selenide.webdriver().shouldHave(WebDriverConditions.url(BASE_URL));
    }
}