package ru.yandex.practicum.api.utils;

import com.github.javafaker.Faker;
import ru.yandex.practicum.api.models.UserRegisterRequest;

import java.util.Locale;

public class DataHelper {
    private final Faker faker;

    public DataHelper() {
        this.faker = new Faker(new Locale("en"));
    }

    public UserRegisterRequest createRandomUser() {
        String email = generateEmail();
        String password = generatePassword();
        String submitPassword = password;
        return new UserRegisterRequest(email, password, submitPassword);
    }

    private String generateEmail() {
        return faker.internet().emailAddress();
    }

    private String generatePassword() {
        return faker.internet().password(8, 12, true, true, true);
    }
}
