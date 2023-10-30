package com.itvedant.studentmanagement.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.studentmanagement.entities.Teacher;
import com.itvedant.studentmanagement.repository.TeacherRepository;

@Service
public class TeacherService {

    // @Autowired
    // private TeacherRepository repository;

    // private Map<Integer, Teacher> teacherMap = new HashMap<>();
    // private AtomicInteger atomic = new AtomicInteger();

    // public Teacher addTeacher(Teacher newTeacher) {
    //     return repository.save(newTeacher);
    // }

    // public Iterable<Teacher> getAllTeachers() {
    //     return repository.findAll();
    // }

    // public Teacher getTeacherById(Integer tid) {
    //     return repository.findById(tid).orElse(null);

    // }

    // public Teacher updatedTeacher(Integer tid, Teacher t) {
    //     t.setId(tid);
    //     return repository.save(t);
    // }

    // public String deleteTeacher(Integer tid) {
    //     repository.deleteById(tid);
    //     return "Teacher deleted successfully";
    // }
}
