package model;

public class AttendanceRecord {

    private Student student;
    private Course course;
    private AttendanceStatus status;

    public AttendanceRecord(Student student, Course course, AttendanceStatus status) {
        this.student = student;
        this.course = course;
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public String toString() {
        return student.getName() + " | " +
                course.getName() + " | Status: " + status;
    }
}
