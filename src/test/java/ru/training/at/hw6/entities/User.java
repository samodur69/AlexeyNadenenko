package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class User extends DataClass<User> {
    String login;
    String password;
    String username;

    public static User ROMAN = new User(
            "Roman",
            "Jdi1234",
            "Roman Iovlev");
}
