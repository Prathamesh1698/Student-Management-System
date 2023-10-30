package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.studentmanagement.entities.Teacher;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @RestResource(path = "email")
    List<Teacher> findByEmail(String email);

    @RestResource(path = "fname")
    List<Teacher> findByFirstName(String name);

    @RestResource(path = "emailhaving")
    List<Teacher> findByEmailContaining(String pattern);
}
