package com.domain.entities;

import com.domain.entities.enumerators.AdminClearanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {

    Integer id;
    String email;
    AdminClearanceType clearanceType;
    Integer userId;

    public Admin(
            Integer id,
            String email,
            AdminClearanceType clearanceType,
            Integer userId
    ) {
        this.id = id;
        this.email = email;
        this.clearanceType = clearanceType;
        this.userId = userId;
    }
}
