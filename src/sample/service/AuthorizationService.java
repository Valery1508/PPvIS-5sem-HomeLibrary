package sample.service;

import sample.model.User;

public interface AuthorizationService {
    User enter(String login, String password);
    User register(boolean parentAccount, String surname, String name, String otchestvo, int age, String login, String password);
    boolean checkUserData(String login, String password);
    User getUserByUserData(String login, String password);
}
