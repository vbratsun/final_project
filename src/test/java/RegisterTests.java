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
import ru.yandex.practicum.api.utils.DataHelper;
import ru.yandex.practicum.constants.Urls;

@DisplayName("Тесты авторизации")
@Epic("Авторизация")
public class RegisterTests extends TestBase{

    private final UserRegisterRequest createdUser = new DataHelper().createRandomUser();

    @Test
    @DisplayName("фывф")
    @Description("фыв")
    @Feature("фыв")
    @Story("фыв")
    public void testOpenHomePage(){
        openPage(Urls.BASE_URI);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации через UI")
    @Feature("Логин")
    @Story("Успешный вход")
    public void testRegistrationSuccess(){
        AuthClient authClient = new AuthClient(Urls.BASE_URI);
        Response response = authClient.registerUser(createdUser);
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}
