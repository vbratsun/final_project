import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.api.clients.AuthClient;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.constants.Urls;

@DisplayName("Тесты на логин")
@Epic("Логин")
public class LoginTests extends TestBase{

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации через UI")
    @Feature("Логин")
    @Story("Успешный вход")
    public void testRegistrationSuccess(){
        UserRegisterRequest createdUser = dataHelper.createRandomUser();

        AuthClient authClient = new AuthClient(Urls.BASE_URI);
        Response response = authClient.registerUser(createdUser);
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}
