package org.example.onlyfortestgitcom.layers.service;

import jakarta.security.auth.message.AuthException;
import org.example.onlyfortestgitcom.enumDir.AuthDir;
import org.example.onlyfortestgitcom.exception.InvalidCredentials;
import org.example.onlyfortestgitcom.exception.UnauthorizedUser;
import org.example.onlyfortestgitcom.layers.repository.RepositoryAuth;
import org.example.onlyfortestgitcom.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAuth {
    RepositoryAuth repositoryAuth;

    public ServiceAuth(RepositoryAuth repositoryAuth) {
        this.repositoryAuth = repositoryAuth;
    }

    public List<AuthDir> getAuthorities(User user)  {
        if (isEmpty(user.getName()) || isEmpty(user.getName())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<AuthDir> userAuthorities = repositoryAuth.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
