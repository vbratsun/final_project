package ru.yandex.practicum.api.models;

public class UserRegisterResponse {
    private User user;
    private AccessToken accessToken;

    public UserRegisterResponse(User user, AccessToken accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }

    public UserRegisterResponse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
