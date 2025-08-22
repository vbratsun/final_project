import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.ui.components.Header;
import ru.yandex.practicum.ui.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты на регистрацию")
@Epic("Регистрация")
public class RegisterTests extends TestBase {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации через UI")
    @Feature("Регистрация")
    @Story("Регистрация")
    public void testSuccessfulRegistration() {
        UserRegisterRequest createdUser = dataHelper.createRandomUser();

        HomePage homePage = new HomePage().openPage();
        Header homePageHeader = homePage.getHeader();
        homePageHeader.clickLoginAndRegisterButton()
                .clickRegisterButton()
                .registerUser(createdUser);

        homePageHeader.shouldBeAuthorized();
        assertEquals("User.", homePageHeader.getUserName(), "Дефолтное имя пользователя не совпадает");
    }
}
