package ru.training.at.hw5.context;

import lombok.Getter;

@Getter
public class User {

    private final String login;
    private final String password;
    private final String fullName;

    public static final User ROMAN_IOVLEV = new User(
            "Roman",
            "Jdi1234",
            "Roman Iovlev");

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}
