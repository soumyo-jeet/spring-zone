package in.soumyo.CRUDSpringBoot;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentEntity createStudent (StudentEntity student) {
        // bussiness logic

        // save to db
        System.out.println("Student service (in)");
        StudentEntity createdStudent = repository.save(student);
        System.out.println("Student service (out)");

        return createdStudent;
    }

    public StudentEntity getStudent (String id) {
        Optional<StudentEntity> student = repository.findById(id); // may return nothing

        if(student.isPresent()) return student.get();
        return null;
    }

    public StudentEntity updateStudent (String id, StudentEntity student) {
        Optional<StudentEntity> oldStudent = repository.findById(id); // may return nothing

        if(!oldStudent.isPresent()) return null;

        StudentEntity newStudent = oldStudent.get();

        newStudent.setAge(student.getAge());
        newStudent.setEmail(student.getEmail());
        newStudent.setYear(student.getYear());
        newStudent.setName(student.getName());

        StudentEntity updatedStudent = repository.save(newStudent);
        return updatedStudent;
    }


    public Boolean deleteStudent (String id) {
        Optional<StudentEntity> student = repository.findById(id); // may return nothing

        if(!student.isPresent()) return false;

        StudentEntity targetStudent = student.get();
        repository.delete(targetStudent);
        return true;
    }
}
