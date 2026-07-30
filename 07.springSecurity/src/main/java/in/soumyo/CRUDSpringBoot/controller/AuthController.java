package in.soumyo.CRUDSpringBoot.controller;

import in.soumyo.CRUDSpringBoot.StudentEntity;
import in.soumyo.CRUDSpringBoot.service.AuthService;
import in.soumyo.CRUDSpringBoot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService service;
    private StudentService studentService;

    public AuthController (AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody StudentEntity student) {
        return ResponseEntity.ok(service.login(student.getName(), student.getPassword()));
    }

    @PostMapping("/signup")
    public ResponseEntity<StudentEntity> createStudent (@RequestBody StudentEntity student) {
        StudentEntity createStudent = studentService.createStudent(student);

        return ResponseEntity.status(201).body(createStudent);
    }
}
