package com.domain.entities;

import com.domain.entities.enumerators.DepartmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {

    Integer id;
    String departmentName;
    DepartmentType departmentType;

    public Department(
            Integer id,
            String departmentName,
            DepartmentType departmentType
    ) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentType = departmentType;
    }
}
