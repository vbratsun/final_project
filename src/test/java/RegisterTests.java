import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.constants.Urls;
import ru.yandex.practicum.ui.pages.HomePage;
import ru.yandex.practicum.ui.pages.LoginPage;
import ru.yandex.practicum.ui.pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тесты на регистрацию")
@Epic("Регистрация")
public class RegisterTests extends TestBase {

    @Test
    @DisplayName("blablabla")
    @Description("blablabla")
    @Feature("blablabla")
    @Story("blablabla")
    public void testSuccessfulRegistration() {
        UserRegisterRequest createdUser = dataHelper.createRandomUser();

        HomePage homePage = open(Urls.HOME_PAGE_URL, HomePage.class);
        homePage.clickLoginAndRegisterButton()
                .clickRegisterButton()
                .registerUser(createdUser);

        sleep(5000);
    }
}
