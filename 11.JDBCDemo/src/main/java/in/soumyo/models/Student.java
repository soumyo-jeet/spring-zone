package in.soumyo.models;

public class Student {
    int id;
    String name;
    String pass;
    public Student () {}

    public Student(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Pass: " + pass;
    }
}
