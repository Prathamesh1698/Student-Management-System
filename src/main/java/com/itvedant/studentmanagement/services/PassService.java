package com.itvedant.studentmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itvedant.studentmanagement.entities.RegisteredFaculty;
import com.itvedant.studentmanagement.repository.RegisteredFacultyRepository;

@Service
public class PassService {
    
    @Autowired
    private RegisteredFacultyRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

public String register(RegisteredFaculty faculty){
    String encodedPassword = passwordEncoder.encode(faculty.getPassword());
    faculty.setPassword(encodedPassword);
    this.repository.save(faculty);
    return "Employee registered successfully.";
}
}
