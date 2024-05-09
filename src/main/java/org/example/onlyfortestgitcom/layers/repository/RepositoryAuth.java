package org.example.onlyfortestgitcom.layers.repository;

import jakarta.security.auth.message.AuthException;
import org.example.onlyfortestgitcom.enumDir.AuthDir;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryAuth {
    Map<String, String> authMap = Map.of("name1", "password1", "name2", "password2");

    public List<AuthDir> getUserAuthorities(String username, String password)  {
        if (authMap.containsKey(username) && authMap.get(username).equals(password)) {
            return List.of(AuthDir.DELETE, AuthDir.READ, AuthDir.WRITE);
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
