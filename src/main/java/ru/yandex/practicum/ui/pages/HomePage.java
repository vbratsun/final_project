package ru.yandex.practicum.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    private final By loginAndRegisterButtonSelector = byXpath("//button[text()='Вход и регистрация']");

    private final SelenideElement loginAndRegisterButton = $(loginAndRegisterButtonSelector);

    public LoginPage clickLoginAndRegisterButton() {
        loginAndRegisterButton.click();

        LoginPage loginPage = page(LoginPage.class);

        return loginPage;
    }
}
