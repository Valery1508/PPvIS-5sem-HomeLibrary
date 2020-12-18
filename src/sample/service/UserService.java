package sample.service;

import sample.model.User;

public interface UserService {
    void createUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getUser();
}
