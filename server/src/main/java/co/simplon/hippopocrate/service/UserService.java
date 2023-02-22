package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.User;

public interface UserService {

    User findUserByName(String name);

    List<User> findAllUsers();
}
