package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.studentmanagement.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
