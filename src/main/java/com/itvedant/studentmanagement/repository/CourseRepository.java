package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.studentmanagement.entities.Course;
import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByCourse(String course);
}
