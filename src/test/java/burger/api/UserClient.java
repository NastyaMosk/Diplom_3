package burger.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserClient {

    private static final String BASE_URI = "https://stellarburgers.education-services.ru";

    @Step("Создать пользователя через API")
    public static Response createUser(User user) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URI)
                .body(user)
                .post("/api/auth/register");
    }

    @Step("Удалить пользователя через API")
    public static void deleteUser(String accessToken) {
        if (accessToken != null && !accessToken.isEmpty()) {
            RestAssured.given()
                    .header("Authorization", accessToken)
                    .baseUri(BASE_URI)
                    .delete("/api/auth/user");
        }
    }
}