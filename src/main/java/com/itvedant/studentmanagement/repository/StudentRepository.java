package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.itvedant.studentmanagement.entities.Student;
import com.itvedant.studentmanagement.entities.StudentWithoutPassword;

import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@RepositoryRestResource(excerptProjection = StudentWithoutPassword.class)
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Secured("ROLES_Head")
    @RestResource(path = "email")
    Student findByEmail(String email);

    // @RestResource(path = "fname")
    @PreAuthorize("hasRole('HR')")
    List<Student> findByFirstName(String firstname);

    @RolesAllowed("HR")
    @RestResource(path = "emailhaving")
    List<Student> findByEmailContaining(String pattern);

}
