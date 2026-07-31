package in.soumyo.CRUDSpringBoot.service;

import in.soumyo.CRUDSpringBoot.StudentEntity;
import in.soumyo.CRUDSpringBoot.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentEntity createStudent (StudentEntity student) {
        student.setDeleted(false);
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        Optional<StudentEntity> existedStudent = repository.findByName(student.getName());
        if(existedStudent.isPresent()) throw new IllegalArgumentException("Username already exists");

        StudentEntity createdStudent = repository.save(student);
        return createdStudent;
    }

    public StudentEntity getStudent (String id) {
        // custom db-method
        Optional<StudentEntity> student = repository.findByIdAndDeletedIsFalse(id); // may return nothing

        if(student.isPresent()) return student.get();
        else throw new IllegalArgumentException("User not found");
    }

    public List<StudentEntity> getStudentByAge () {
        Optional<List<StudentEntity>> students = repository.findByDeletedIsFalseAndAgeGreaterThan(18);

        if(students.isPresent()) return students.get();
        return null;
    }

    public StudentEntity updateStudent (String id, StudentEntity student) {
        Optional<StudentEntity> oldStudent = repository.findByIdAndDeletedIsFalse(id); // may return nothing

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
        Optional<StudentEntity> student = repository.findByIdAndDeletedIsFalse(id); // may return nothing

        if(!student.isPresent()) return false;

        StudentEntity targetStudent = student.get();
        repository.delete(targetStudent);
        return true;
    }

    public Boolean deleteStudentSoftly (String id) {
        Optional<StudentEntity> student = repository.findByIdAndDeletedIsFalse(id); // may return nothing

        if(!student.isPresent()) return false;

        StudentEntity targetStudent = student.get();
        targetStudent.setDeleted(true);
        repository.save(targetStudent);
        return true;
    }
}
