package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.studentmanagement.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>  {
    
}
