package in.soumyo.CRUDSpringBoot;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentEntity createStudent (StudentEntity student) {
        // bussiness logic

        // save to db
        StudentEntity createdStudent = repository.saveStudent(student);
        return createdStudent;
    }
}
