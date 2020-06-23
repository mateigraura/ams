package com.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;
    private String email;
    private String passwordHash;

    public User(
            Integer id,
            String email,
            String passwordHash
    ) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}
