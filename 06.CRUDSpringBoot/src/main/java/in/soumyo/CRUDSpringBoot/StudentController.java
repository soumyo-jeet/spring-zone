package in.soumyo.CRUDSpringBoot;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}