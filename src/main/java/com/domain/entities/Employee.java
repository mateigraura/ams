package com.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    Integer id;
    String name;
    String email;
    String employeeCode;
    Integer userId;
    Integer departmentId;

    public Employee(
            Integer id,
            String name,
            String email,
            String employeeCode,
            Integer userId,
            Integer departmentId
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.employeeCode = employeeCode;
        this.userId = userId;
        this.departmentId = departmentId;
    }
}
