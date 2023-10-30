package com.itvedant.studentmanagement.Controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.studentmanagement.entities.Teacher;
import com.itvedant.studentmanagement.services.TeacherService;

import jakarta.validation.Valid;

@RestController
public class TeacherController {

    // @Autowired
    // private TeacherService teacherService;

    // @PostMapping("/teachers")
    // public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher t) {
    //     return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.addTeacher(t));
    // }

    // @GetMapping("/teachers/{id}")
    // public ResponseEntity<?> getTeacher(@PathVariable Integer id) {
    //     Teacher found = teacherService.getTeacherById(id);
    //     if (found == null) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Teacher with this ID does not exist.");
    //     } else {
    //         return ResponseEntity.ok().body(found);
    //     }
    // }

    // @GetMapping("/teachers")
    // public ResponseEntity<?> getTeachers() {
    //     return ResponseEntity.ok().body(teacherService.getAllTeachers());
    // }

    // @PutMapping("/teachers/{id}")
    // public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Teacher tid) {
    //     Teacher found = teacherService.getTeacherById(id);
    //     if (found == null) {
    //         return ResponseEntity.badRequest().body("Teacher with this ID does not exist.");
    //     } else {
    //         tid.setCreationTime(found.getCreationTime());
    //         return ResponseEntity.ok().body(teacherService.updatedTeacher(id, tid));
    //     }
    // }

    // @DeleteMapping("/teachers/{id}")
    // public ResponseEntity<?> delete(@PathVariable Integer id) {
    //     Teacher found = teacherService.getTeacherById(id);
    //     if (found == null) {
    //         return ResponseEntity.badRequest().body("Teacher with this ID does not exist.");
    //     } else {
    //         return ResponseEntity.ok().body(teacherService.deleteTeacher(id));
    //     }
    // }
}
