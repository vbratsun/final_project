import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.api.clients.AuthClient;
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

    @BeforeEach
    public void setup() {
        this.configureDriverAndBrowser();
        this.dataHelper = new DataHelper();
        this.authClient = new AuthClient(Urls.BASE_URI);
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
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
}