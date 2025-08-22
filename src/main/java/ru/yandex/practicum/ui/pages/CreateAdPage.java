package ru.yandex.practicum.ui.pages;

import ru.yandex.practicum.constants.Urls;

import static com.codeborne.selenide.Selenide.open;

public class CreateAdPage {

    public CreateAdPage openPage() {
        open(Urls.CREATE_AD_PAGE_URL);
        return this;
    }
}
