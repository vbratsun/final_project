import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.ui.components.AdCard;
import ru.yandex.practicum.ui.pages.CreateAdPage;
import ru.yandex.practicum.ui.pages.EditAdPage;
import ru.yandex.practicum.ui.pages.ProfilePage;

@DisplayName("Тесты на создание объявления")
@Epic("Объявления")
public class AdTests extends TestBase {

    private final String EDIT_AD_LABEL_TEXT = "Редактирование объявления";

    private CreateAdPage createAdPage;

    @Override
    public void setup() {
        super.setup();

        this.loginPage = this.loginPage.openPage();
        this.createAdPage = this.loginPage
                .loginUser(this.createdUser)
                .getHeader()
                .shouldBeAuthorized()
                .clickCreateAdButton();
    }

    @Test
    @DisplayName("Успешное создание объявления")
    @Description("Успешное создание объявления в любой категории")
    @Feature("Объявления")
    @Story("Объявления")
    public void testAdCanBeCreated() {
        ProfilePage profilePage = this.createAdPage.createAd(this.createdAd)
                .getHeader()
                .clickProfileButton();

        profilePage.shouldHaveAdvertisements();
    }

    @Test
    @DisplayName("Успешное изменение объявления")
    @Description("Успешное редактирование своего объявления")
    @Feature("Объявления")
    @Story("Объявления")
    public void testAdCanBeEdited() {
        ProfilePage profilePage = this.createAdPage.createAd(this.createdAd)
                .getHeader()
                .clickProfileButton();
        profilePage.shouldHaveAdvertisements();

        AdCard firstAd = profilePage.getAllAdvertisements().get(0);
        EditAdPage editAdPage = firstAd.editAd();
        editAdPage.shouldHaveTitle(EDIT_AD_LABEL_TEXT);
    }

    @Test
    @DisplayName("Успешное удаление объявления")
    @Description("Успешное удаление своего объявлени")
    @Feature("Объявления")
    @Story("Объявления")
    public void testAdCanBeDeleted() {
        ProfilePage profilePage = this.createAdPage.createAd(this.createdAd)
                .getHeader()
                .clickProfileButton();
        profilePage.shouldHaveAdvertisements();

        AdCard firstAd = profilePage.getAllAdvertisements().get(0);
        firstAd.shouldHaveDeleteButton();
    }
}
