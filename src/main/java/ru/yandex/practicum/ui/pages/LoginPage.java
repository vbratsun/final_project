package ru.yandex.practicum.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private final By registerButtonSelector = byXpath("//button[text()='Нет аккаунта']");

    private final SelenideElement registerButton = $(registerButtonSelector);

    public RegistrationPage clickRegisterButton() {
        registerButton.click();

        RegistrationPage registrationPage = page(RegistrationPage.class);

        return registrationPage;
    }
}
