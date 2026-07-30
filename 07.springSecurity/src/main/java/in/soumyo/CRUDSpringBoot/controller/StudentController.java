package in.soumyo.CRUDSpringBoot.controller;


import in.soumyo.CRUDSpringBoot.StudentEntity;
import in.soumyo.CRUDSpringBoot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // create
    @PostMapping
    public ResponseEntity<StudentEntity> createStudent (@RequestBody StudentEntity student) {
        System.out.println("Create Controller (in)");
        StudentEntity createStudent = service.createStudent(student);
        System.out.println("Create Controller (out)");

        return ResponseEntity.status(201).body(createStudent);
    }

    // read
    @GetMapping("get/{id}")
    public ResponseEntity<StudentEntity> getStudent (@PathVariable String id) {
        StudentEntity reqStudent = service.getStudent(id);

        if(reqStudent == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(reqStudent);
    }

    // get by params
    @GetMapping("get")
    public ResponseEntity<StudentEntity> getStudentByParams (@RequestParam String id) {
        StudentEntity reqStudent = service.getStudent(id);

        if(reqStudent == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(reqStudent);
    }

    // get all age > 18
    @GetMapping("get/adult")
    public ResponseEntity<List<StudentEntity>> getStudentByAge () {
        List<StudentEntity> reqStudents = service.getStudentByAge();

        if(reqStudents == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(reqStudents);
    }

    // update
    @PutMapping("update/{id}")
    public ResponseEntity<StudentEntity> updateStudent (@PathVariable String id,
                                                        @RequestBody StudentEntity student) {
        StudentEntity reqStudent = service.updateStudent(id, student);

        if(reqStudent == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(reqStudent);
    }


    // delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable String id) {
        Boolean flag = service.deleteStudent(id);

        if(!flag) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok("deleted successfully.");
    }

    @PatchMapping("delete/soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly (@PathVariable String id) {
        Boolean flag = service.deleteStudentSoftly(id);

        if(!flag) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok("deleted successfully.");
    }
}