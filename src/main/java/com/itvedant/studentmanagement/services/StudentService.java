package com.itvedant.studentmanagement.services;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.studentmanagement.FileStorageProperties;
import com.itvedant.studentmanagement.entities.Student;
import com.itvedant.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    private final Path rootLocation;

    public StudentService(FileStorageProperties properties) {
        this.rootLocation = Paths.get(properties.getUploadDir());

        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "could not create the directories for upload and download.");

        }
    }

    public String storeFile(Integer id, MultipartFile file) {

        Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));

        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "could not save the file.");
        }

        String uploadedFileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/student/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        Student student = this.repository.findById(id).get();
        student.setId(id);
        student.setAssignmentUrl(uploadedFileUrl);
        this.repository.save(student);
        return "File uploaded successfully.";
    }

    public Resource downloadFile(String filename){
        Path file = rootLocation.resolve(filename);

        try{
            Resource resource = new UrlResource(file.toUri());

            return resource;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                              "Could not download the file");
        }
    }













    

    // private Map<Integer, Student> studentMap = new HashMap<>();
    // private AtomicInteger atomic = new AtomicInteger();

    // public Iterable<Student> getStudents() {
    // // return studentMap.values();
    // return repository.findAll();
    // }

    // public Student add(Student s) {
    // return repository.save(s);
    // }

    // public Student getStudentById(Integer sid) {
    // return repository.findById(sid).orElse(null);
    // }

    // public String deleteStudent(Integer id) {
    // repository.deleteById(id);
    // return "Student deleted successfully.";
    // }

    // public Student updateStudent(Integer id, Student s) {
    // s.setId(id);
    // return repository.save(s);
    // }
}
