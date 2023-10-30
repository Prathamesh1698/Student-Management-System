package com.itvedant.studentmanagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.studentmanagement.entities.RegisteredFaculty;
import com.itvedant.studentmanagement.services.PassService;

@RestController
public class PassController {

    @Autowired
    private PassService service;

    @PostMapping("/register")
    public ResponseEntity<?> registerFaculty(@RequestBody RegisteredFaculty faculty){
        return ResponseEntity.ok(this.service.register(faculty));
    }
}
