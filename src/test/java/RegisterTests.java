import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.ui.components.Header;
import ru.yandex.practicum.ui.pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты на регистрацию")
@Epic("Регистрация")
public class RegisterTests extends TestBase {

    private final String DEFAULT_USER_NAME = "User.";

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация с уникальным email")
    @Feature("Регистрация")
    @Story("Регистрация")
    public void testUserCanBeRegistered() {
        this.createdUser = this.dataHelper.createRandomUser();

        this.homePage = this.homePage.openPage();
        Header homePageHeader = this.homePage.getHeader();
        homePageHeader.clickLoginAndRegisterButton()
                .clickRegisterButton()
                .registerUser(this.createdUser);

        homePageHeader.shouldBeAuthorized();
        assertEquals(DEFAULT_USER_NAME, homePageHeader.getUserName(),
                "Дефолтное имя пользователя не совпадает");
    }

    @Test
    @DisplayName("Не успешная регистрация")
    @Description("Попытка зарегистрироваться повторно")
    @Feature("Регистрация")
    @Story("Регистрация")
    public void testUserCanNotBeRegisteredWithSameCredentials(){
        this.homePage = this.homePage.openPage();
        RegistrationPage registrationPage = this.homePage.getHeader()
                .clickLoginAndRegisterButton()
                .clickRegisterButton()
                .tryRegisterUser(this.createdUser)
                .shouldBeFailedRegistration();
    }
}
