package sample.service;

import sample.model.User;

import java.util.List;

public class UserServiceImplementation implements UserService {

    User user;
    List<User> listOfUsers; //todo добавить в ошибки
    @Override
    public void createUser(User user) {
        // some logic
    }

    @Override
    public void deleteUser(User user) {
        // some logic
    }

    @Override
    public void editUser(User user) {
        // some logic
    }

    @Override
    public User getUser() {
        // some logic
        return null;
    }

    public void setListOfUsers(List<User> list){        //
        this.listOfUsers = list;
    }

    public List<User> getAllUsers(){    //
        return listOfUsers;
    }

    public void addUser(User user){ //
        listOfUsers.add(user);
    }
}
