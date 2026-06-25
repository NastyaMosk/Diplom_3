package burger.tests;

import burger.api.UserClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected String accessToken;
    public static final String BASE_URL = "https://stellarburgers.education-services.ru/";

    @Before
    public void setUp() {

        Configuration.baseUrl = BASE_URL;

        String browser = System.getProperty("browser", "chrome");

        if ("yandex".equalsIgnoreCase(browser)) {

            Configuration.browserBinary = "C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
        } else {
            Configuration.browser = "chrome";
        }

        Configuration.timeout = 8000;
        Configuration.browserSize = "1920x1080";

        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
}