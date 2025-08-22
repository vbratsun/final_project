import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.ui.components.Header;
import ru.yandex.practicum.ui.pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты на регистрацию")
@Epic("Регистрация")
public class RegisterTests extends TestBase {

    private final String DEFAULT_USER_NAME = "User.";

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации через UI")
    @Feature("Регистрация")
    @Story("Регистрация")
    public void testUserCanBeRegistered() {
        UserRegisterRequest createdUser = this.dataHelper.createRandomUser();

        this.homePage = this.homePage.openPage();
        Header homePageHeader = this.homePage.getHeader();
        homePageHeader.clickLoginAndRegisterButton()
                .clickRegisterButton()
                .registerUser(createdUser);

        homePageHeader.shouldBeAuthorized();
        assertEquals(DEFAULT_USER_NAME, homePageHeader.getUserName(), "Дефолтное имя пользователя не совпадает");
    }

    @Test
    @DisplayName("Не успешная регистрация существующим пользователем")
    @Description("Проверка не успешной регистрации через UI существующим пользователем")
    @Feature("Регистрация")
    @Story("Регистрация")
    public void testUserCanNotBeRegisteredWithSameCredentials(){
        UserRegisterRequest createdUser = this.dataHelper.createRandomUser();

        Response response = this.authClient.registerUser(createdUser);
        response.then().statusCode(HttpStatus.SC_CREATED);

        this.homePage = this.homePage.openPage();
        RegistrationPage registrationPage = this.homePage.getHeader()
                .clickLoginAndRegisterButton()
                .clickRegisterButton();

        registrationPage.tryRegisterUser(createdUser)
                .shouldBeFailedRegistration();
    }
}
