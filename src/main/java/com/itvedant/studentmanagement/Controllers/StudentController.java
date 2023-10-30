package com.itvedant.studentmanagement.Controllers;

import java.util.Collection;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itvedant.studentmanagement.entities.Student;
import com.itvedant.studentmanagement.services.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PutMapping("students/{id}/upload")
    public ResponseEntity<?> upload(@PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(studentService.storeFile(id, file));
    }

    @GetMapping("/student/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        Resource resource = this.studentService.downloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
}
