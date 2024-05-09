package org.example.onlyfortestgitcom.layers.repository;

import jakarta.security.auth.message.AuthException;
import org.example.onlyfortestgitcom.enumDir.AuthDir;
import org.example.onlyfortestgitcom.pojo.User;
import org.springframework.stereotype.Repository;

import java.net.UnknownServiceException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryAuth {
    Map<String, User> authMap = Map.of("name1@yandex.ru", new User("name1@yandex.ru","password"));

    public List<AuthDir> getUserAuthorities(User user)  {
        if (authMap.containsKey(user.getName()) && authMap.get(user.getName()).getPassword().equals(user.getPassword())) {
            return List.of(AuthDir.DELETE, AuthDir.READ, AuthDir.WRITE);
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
