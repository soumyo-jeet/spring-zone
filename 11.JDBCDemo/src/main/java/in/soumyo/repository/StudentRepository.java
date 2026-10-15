package in.soumyo.repository;

import in.soumyo.models.Student;

import java.sql.*;

public class StudentRepository {
    Student student;
    String url = "jdbc:sqlite:C:/Users/SOUMYOJEET/database/students.db";;

    public void createStudent (Student student) {
        String q = "INSERT INTO student('name', 'pass') VALUES(?, ?);";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = conn.prepareStatement(q);

                )
        {
            Statement st = conn.createStatement();
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPass());

            int res = preparedStatement.executeUpdate();

            if(res == 1) System.out.println("Inserted successfully.");
            else System.out.println("Insertion failed.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteStudent (String nm) {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            String q = "DELETE FROM student WHERE name=%s;".formatted(nm);
            int res = st.executeUpdate(q);

            if(res == 1) System.out.println("Deleted successfully.");
            else System.out.println("Deletion failed.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getStudentByName (String nm) {
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            String q = "SELECT * FROM student WHERE name='soumyo';";
            ResultSet res = st.executeQuery(q);

            Student student = new Student();

            student.setId(res.getInt("id"));
            student.setName(res.getString("name"));
            student.setPass(res.getString("pass"));

            System.out.println(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
