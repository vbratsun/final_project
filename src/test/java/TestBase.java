import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeEach
    public void setup() {
        // Автоматическая настройка ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Настройки Selenide
        Configuration.browser = "chrome";
        Configuration.timeout = 10000; // 10 секунд
        Configuration.browserSize = "maximize";
        Configuration.headless = false; // true для headless-режима
    }

    @AfterEach
    public void tearDown() {
        // Закрываем браузер
        closeWebDriver();
    }

    // Метод для открытия страниц
    protected void openPage(String url) {
        open(url);
    }
}