package ru.yandex.practicum.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.practicum.constants.Urls;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final By registerButtonSelector = By.xpath("//button[text()='Нет аккаунта']");

    private final SelenideElement registerButton = $(registerButtonSelector);

    public LoginPage openPage() {
        open(Urls.LOGIN_PAGE_URL);
        return this;
    }

    public RegistrationPage clickRegisterButton() {
        registerButton.click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        return registrationPage;
    }
}
