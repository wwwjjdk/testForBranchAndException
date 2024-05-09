package org.example.onlyfortestgitcom.exception;

public class UnauthorizedUser extends RuntimeException{

    public UnauthorizedUser() {
        super();
    }

    public UnauthorizedUser(String message) {
        super(message);
    }
}
