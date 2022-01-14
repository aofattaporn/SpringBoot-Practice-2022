package com.example.practice.business;

import com.example.practice.entity.User;
import com.example.practice.exception.UserException;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserBusiness {

    @Autowired
    private UserService userService;

    public void saveUser(User user) throws UserException {
        if (Objects.isNull(user)) {
            throw UserException.UserInputFail();
        } else if (user.getEmail().isEmpty()) {
            throw UserException.UserInputEmailNull();
        } else if (user.getName().isEmpty()) {
            throw UserException.UserInputUserNameNull();
        } else {
            userService.saveUser(user);
        }
    }

    public Optional<User> getUserByID(Long id) throws UserException {
        Optional<User> response = userService.getUserById(id);
        if (response.isEmpty()) {
            throw UserException.UserNotFoundException();
        } else {
            return userService.getUserById(id);
        }
    }

    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    public void deleteUsers() {
        userService.deleteUsers();
    }

    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }

}
