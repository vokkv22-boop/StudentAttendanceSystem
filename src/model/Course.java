package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }
}
