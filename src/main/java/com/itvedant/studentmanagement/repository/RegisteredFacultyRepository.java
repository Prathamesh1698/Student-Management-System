package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.studentmanagement.entities.RegisteredFaculty;

public interface RegisteredFacultyRepository 
    extends JpaRepository<RegisteredFaculty, Integer> {
        
       @RestResource(exported = false)
        <S extends RegisteredFaculty> S save(S entity);

        RegisteredFaculty findByEmail(String email);
}
