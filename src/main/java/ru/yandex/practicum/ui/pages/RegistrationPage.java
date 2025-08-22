package ru.yandex.practicum.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.practicum.api.models.UserRegisterRequest;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    private final By emailInputSelector = byXpath("//input[@name='email']");
    private final By passwordInputSelector = byXpath("//input[@name='password']");
    private final By submitPasswordInputSelector = byXpath("//input[@name='submitPassword']");
    private final By createAccountButtonSelector = byXpath("//button[text()='Создать аккаунт']");

    private final SelenideElement emailInput = $(emailInputSelector);
    private final SelenideElement passwordInput = $(passwordInputSelector);
    private final SelenideElement submitPasswordInput = $(submitPasswordInputSelector);
    private final SelenideElement createAccountButton = $(createAccountButtonSelector);

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void setSubmitPassword(String submitPassword) {
        submitPasswordInput.setValue(submitPassword);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public HomePage registerUser(UserRegisterRequest user){
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setSubmitPassword(user.getSubmitPassword());
        clickCreateAccountButton();

        HomePage homapage = page(HomePage.class);

        return homapage;
    }
}
