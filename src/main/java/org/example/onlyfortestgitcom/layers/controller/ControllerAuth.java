package org.example.onlyfortestgitcom.layers.controller;

import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;
import org.example.onlyfortestgitcom.enumDir.AuthDir;
import org.example.onlyfortestgitcom.exception.InvalidCredentials;
import org.example.onlyfortestgitcom.exception.UnauthorizedUser;
import org.example.onlyfortestgitcom.layers.service.ServiceAuth;
import org.example.onlyfortestgitcom.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class ControllerAuth {
    ServiceAuth serviceAuth;

    public ControllerAuth(ServiceAuth serviceAuth) {
        this.serviceAuth = serviceAuth;
    }

    @GetMapping("authorize")
    public List<AuthDir> getAuthorities(@Valid User user) {
        return serviceAuth.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    String ex1(InvalidCredentials invalidCredentials) {
        return invalidCredentials.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    String ex(UnauthorizedUser unauthorizedUser) {
        return unauthorizedUser.getMessage();

    }
}
