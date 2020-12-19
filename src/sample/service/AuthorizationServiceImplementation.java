package sample.service;

import sample.model.User;

public class AuthorizationServiceImplementation implements AuthorizationService {
    @Override
    public User enter(String login, String password) {
        // some logic
        return null;
    }

    @Override
    public User register(boolean parentAccount, String surname, String name, String otchestvo, int age, String login, String password) {
        // some logic
        return null;
    }

    @Override
    public boolean checkUserData(String login, String password) {
        // some logic
        return false;
    }

    @Override
    public User getUserByUserData(String login, String password) {
        // some logic
        return null;
    }
}
