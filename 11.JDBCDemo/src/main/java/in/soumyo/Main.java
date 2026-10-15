package in.soumyo;

import in.soumyo.models.Student;
import in.soumyo.repository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        StudentRepository repo = new StudentRepository();
        repo.createStudent(new Student("ujjwal", "lala"));
        // repo.getStudentByName();
    }
}
