package burger.tests;

import burger.pageobjects.MainPage;
import burger.pageobjects.LoginPage;
import burger.pageobjects.RegisterPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class RegisterTest extends BaseTest {

    @Test
    @Description("Успешная регистрация пользователя с валидными данными")
    public void testSuccessfulRegistration() {
        Selenide.open(BASE_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage();
        // Генерируем случайную почту, чтобы тесты не падали из-за дубликатов
        String uniqueEmail = "qa_user_" + UUID.randomUUID() + "@yandex.ru";

        registerPage.register("Дипломник", uniqueEmail, "correctPassword123");

        // После успешной регистрации приложение автоматически редиректит на страницу входа
        Assert.assertTrue("Кнопка 'Войти' должна отображаться после успешной регистрации", loginPage.isLoginButtonDisplayed());
    }

    @Test
    @Description("Отображение ошибки при регистрации с некорректным (коротким) паролем")
    public void testRegistrationWithShortPasswordShowsError() {
        Selenide.open(BASE_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage();
        // Передаем некорректный пароль меньше 6 символов
        registerPage.register("Дипломник", "short_pwd@test.ru", "12345");

        Assert.assertTrue("Должна отображаться ошибка 'Некорректный пароль'", registerPage.isPasswordErrorDisplayed());
    }
}