package com.example.practice.exception;

public class UserException extends RuntimeException {

    public UserException(String msg) {
        super("user.error." + msg);
    }

    public static UserException UserNotFoundException() {
        return new UserException("not.found.");
    }

    public static UserException UserInputFail() {
        return new UserException("input.fail.");
    }

    public static UserException UserInputEmailNull() {
        return new UserException("input.fail.email.null.");
    }

    public static UserException UserInputUserNameNull() {
        return new UserException("input.fail.username.null.");
    }


}

