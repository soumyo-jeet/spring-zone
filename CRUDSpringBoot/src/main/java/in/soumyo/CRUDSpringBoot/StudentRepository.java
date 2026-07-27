package in.soumyo.CRUDSpringBoot;


import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public StudentEntity saveStudent (StudentEntity student) {
        System.out.println("Student Repository (in)");
        // contact to db
        System.out.println("Student Repository (out)");

        return student;
    }
}
