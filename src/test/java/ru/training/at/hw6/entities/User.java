package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;

@Getter
public class User extends DataClass<User> {
    private String login;
    private String password;
    private String username;

    public static User ROMAN = new User(
            "Roman",
            "Jdi1234",
            "Roman Iovlev");

    public User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
