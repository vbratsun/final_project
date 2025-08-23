import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.ui.pages.CreateAdPage;
import ru.yandex.practicum.ui.pages.ProfilePage;

@DisplayName("Тесты на создание объявления")
@Epic("Создание объявления")
public class AdTests extends TestBase {

    @Test
    @DisplayName("Успешное создание объявления")
    @Description("Успешное создание объявления в любой категории")
    @Feature("Создание объявления")
    @Story("Создание объявления")
    public void testAdCanBeCreated() {
        this.loginPage = this.loginPage.openPage();
        CreateAdPage createAdPage = this.loginPage
                .loginUser(this.createdUser)
                .getHeader()
                .shouldBeAuthorized()
                .clickCreateAdButton();

        ProfilePage profilePage = createAdPage.createAd(this.createdAd)
                .getHeader()
                .clickProfileButton();

        profilePage.shouldHaveAdvertisements();
    }
}
