package de.xing.api;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class ReqresAPI {
    private static final String BASE_URL = "https://reqres.in/api";
    private static final String USERS = BASE_URL + "/users";
    private static final String USERS_BY_PAGE = USERS + "?page=%s";
    private static final String USER_BY_ID = USERS + "/%s";

    public static URL users() throws MalformedURLException {
        return new URL(USERS);
    }

    public static URL getUsersByPage(int page) throws MalformedURLException {
        return new URL(format(USERS_BY_PAGE, page));
    }

    public static URL userWithID(int id) throws MalformedURLException {
        return new URL(format(USER_BY_ID, id));
    }
}
