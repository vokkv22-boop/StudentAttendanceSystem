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

    public String toString() {
        return student.getName() + " | " +
                course.getName() + " | Status: " + status;
    }
}
