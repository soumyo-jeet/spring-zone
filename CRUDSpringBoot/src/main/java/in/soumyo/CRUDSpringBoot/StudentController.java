package in.soumyo.CRUDSpringBoot;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // update

    // delete
}