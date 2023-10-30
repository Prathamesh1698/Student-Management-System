package com.itvedant.studentmanagement.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "studentwithoutpassword", types = { Student.class })
public interface StudentWithoutPassword {
    String getFirstName();

    String getLastName();

    String getEmail();

    String getAssignmentUrl();

    // String getMobile();

}
