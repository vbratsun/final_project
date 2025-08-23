import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.api.clients.AuthClient;
import ru.yandex.practicum.api.models.CreateAdRequest;
import ru.yandex.practicum.api.models.UserRegisterRequest;
import ru.yandex.practicum.api.utils.DataHelper;
import ru.yandex.practicum.constants.Urls;
import ru.yandex.practicum.ui.pages.HomePage;
import ru.yandex.practicum.ui.pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected DataHelper dataHelper;
    protected AuthClient authClient;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected UserRegisterRequest createdUser;
    protected CreateAdRequest createdAd;

    @BeforeEach
    public void setup() {
        this.configureDriverAndBrowser();
        this.dataHelper = new DataHelper();
        this.authClient = new AuthClient(Urls.BASE_URI);
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();

        this.createdUser = this.dataHelper.createRandomUser();
        this.createdAd = this.dataHelper.createRandomAd();
        this.registerUser(this.createdUser);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    private void configureDriverAndBrowser(){
        WebDriverManager.chromedriver().setup();

        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "maximize";
        Configuration.headless = false;
    }

    private void registerUser(UserRegisterRequest user){
        Response response = this.authClient.registerUser(this.createdUser);
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}