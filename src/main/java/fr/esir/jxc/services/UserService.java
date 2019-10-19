package fr.esir.jxc.services;

import java.util.List;

import fr.esir.jxc.models.User;

public interface UserService {

    User save(User user);

    User findUserById(String id);

    List<User> findAllUsers();
}
