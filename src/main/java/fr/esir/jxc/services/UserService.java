package fr.esir.jxc.services;

import fr.esir.jxc.models.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(User user);

    Iterable<User> findAll();

    Page<User> findByUsername(String username, PageRequest pageRequest);
}
