import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты на авторизацию")
@Epic("Авторизация")
public class LoginTests extends TestBase{

    @Test
    @DisplayName("Успешная авторизация")
    @Description("Авторизация ранее зарегистрированного пользователя")
    @Feature("Авторизация")
    @Story("Авторизация")
    public void testUserCanLogin(){
        this.loginPage = this.loginPage.openPage();
        this.loginPage.loginUser(this.createdUser)
                .getHeader()
                .shouldBeAuthorized();
    }
}
