import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.constants.Urls;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

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

        openPage(Urls.HOME_PAGE_URL);
        $(byXpath("//button[text()='Вход и регистрация']")).click();
        $(byXpath("//button[text()='Нет аккаунта']")).click();

        $(byXpath("//input[@name='email']")).setValue(createdUser.getEmail());
        $(byXpath("//input[@name='password']")).setValue(createdUser.getPassword());
        $(byXpath("//input[@name='submitPassword']")).setValue(createdUser.getSubmitPassword());

        $(byXpath("//button[text()='Создать аккаунт']")).click();
        sleep(5000);
    }
}
