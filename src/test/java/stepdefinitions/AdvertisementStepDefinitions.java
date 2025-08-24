package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import ru.yandex.practicum.api.utils.DataHelper;
import ru.yandex.practicum.ui.pages.ProfilePage;

public class AdvertisementStepDefinitions {

    private final TestContext context;
    private final DataHelper dataHelper;

    public AdvertisementStepDefinitions(TestContext context) {
        this.context = context;
        this.dataHelper = new DataHelper();
    }

    @Given("Пользователь авторизован в системе")
    public void userIsLoggedIn() {
        context.loginPage.openPage()
                .loginUser(context.createdUser);
    }

    @Given("Пользователь имеет созданное объявление")
    public void userHasCreatedAd() {
        context.createdAd = dataHelper.createRandomAd();
        context.createAdPage = context.homePage.getHeader()
                .clickCreateAdButton();
        context.createAdPage.createAd(context.createdAd);
    }

    @When("Пользователь создает новое объявление")
    public void userCreatesNewAd() {
        context.createdAd = dataHelper.createRandomAd();
        context.createAdPage = context.homePage.getHeader()
                .clickCreateAdButton();
        context.createAdPage.createAd(context.createdAd);
    }

    @When("Пользователь редактирует объявление")
    public void userEditsAd() {
        ProfilePage profilePage = context.homePage.getHeader().clickProfileButton();
        context.editAdPage = profilePage.getAllAdvertisements().get(0).editAd();
    }

    @When("Пользователь просматривает свои объявления")
    public void userViewsAds() {
        context.profilePage = context.homePage.getHeader().clickProfileButton();
    }

    @Then("Объявление отображается в его профиле")
    public void adDisplayedInProfile() {
        context.profilePage.shouldHaveAdvertisements();
    }

    @Then("Форма редактирования объявления открывается")
    public void editAdFormOpens() {
        context.editAdPage.shouldHaveTitle("Редактирование объявления");
    }

    @Then("У объявления доступна кнопка удаления")
    public void deleteButtonAvailable() {
        context.profilePage.getAllAdvertisements().get(0).shouldHaveDeleteButton();
    }
}