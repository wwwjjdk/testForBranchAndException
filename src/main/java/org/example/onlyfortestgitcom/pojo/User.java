package org.example.onlyfortestgitcom.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ToString
@Validated
@AllArgsConstructor
public class User {
    @Email
    private String name;
    @Size(min = 2, max = 10)
    private String password;
}
