package com.example.practice.business;

import com.example.practice.entity.User;
import com.example.practice.entity.UserLogin;
import com.example.practice.exception.UserException;
import com.example.practice.security.PasswordConfig;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserBusiness {

    @Autowired
    private UserService userService;
    private PasswordConfig passwordConfig;

    public void saveUser(User user) throws UserException {
        if (Objects.isNull(user)) {
            throw UserException.UserInputFail();
        } else if (user.getEmail().isEmpty()) {
            throw UserException.UserInputEmailNull();
        } else if (user.getName().isEmpty()) {
            throw UserException.UserInputUserNameNull();
        } else {

            // encoding password
//            user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));

            User temp = new User();
            temp.setName(user.getName());
            temp.setEmail(user.getEmail());
            temp.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));

            userService.createUser(user);
        }
    }

    public String findUser(UserLogin user) throws UserException {
        return "complete";
    }

    public Optional<User> getUserByID(Long id) throws UserException {
        Optional<User> response = userService.readUserById(id);
        if (response.isEmpty()) {
            throw UserException.UserNotFoundException();
        } else {
            return userService.readUserById(id);
        }
    }

    public Iterable<User> getUsers() {
        return userService.readUsers();
    }

    public void updateUser(User user, long id){
        Optional<User> userDB = userService.readUserById(id);

    }

    public void deleteUsers() {
        userService.deleteUsers();
    }

    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }

}
