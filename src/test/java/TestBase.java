import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.api.utils.DataHelper;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected DataHelper dataHelper;

    @BeforeEach
    public void setup() {
        // Автоматическая настройка ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Настройки Selenide
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "maximize";
        Configuration.headless = false;

        // Подготовить тестовые данные
        this.dataHelper = new DataHelper();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}