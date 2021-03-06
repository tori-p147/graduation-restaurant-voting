package com.github.mahou147.voting;

import com.github.mahou147.voting.util.JsonUtil;
import com.github.mahou147.voting.model.Role;
import com.github.mahou147.voting.model.User;

import java.util.List;

public class UserTestData {
    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "registered", "password");
    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;
    public static final int USER3_ID = 3;
    public static final int NOT_FOUND = 10;
    public static final String USER_MAIL = "user@gmail.com";
    public static final String ADMIN_MAIL = "tori.plaksunova@gmail.com";
    public static final String USER3_MAIL = "user3@mail.ru";
    public static final User user = new User(USER_ID, USER_MAIL, "User_First", "User_Last",
            "password", Role.USER);
    public static final User admin = new User(ADMIN_ID, ADMIN_MAIL, "Viktoria", "Plaksunova",
            "admin", Role.ADMIN, Role.USER);
    public static final User user3 = new User(USER3_ID, "user3@mail.ru", "User_Third", "User_Last",
            "password3", Role.USER);
    public static final List<User> users = List.of(admin, user3, user);

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}
