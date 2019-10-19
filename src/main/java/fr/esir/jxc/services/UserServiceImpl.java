package fr.esir.jxc.services;

import fr.esir.jxc.exceptions.UserNotFoundException;
import fr.esir.jxc.models.User;
import fr.esir.jxc.repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findUserById(String id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id : "+ id + " does not exist."));
    }

    public List<User> findAllUsers(){
        return this.userRepository.findAll().getContent();
    }

}
