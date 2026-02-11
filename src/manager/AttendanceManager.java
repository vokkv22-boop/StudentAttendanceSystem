package manager;

import model.AttendanceRecord;
import model.Student;
import model.Course;
import model.AttendanceStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Serializable {

    private List<Student> allStudents = new ArrayList<>();
    private List<Course> allCourses = new ArrayList<>();
    private List<AttendanceRecord> allAttendanceRecords = new ArrayList<>();


    public List<Student> getAllStudents() {
        return allStudents;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        return allAttendanceRecords;
    }


    public void markAttendance(Student student, Course course, AttendanceStatus status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        allAttendanceRecords.add(record);
    }


    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(allStudents);
            out.writeObject(allCourses);
            out.writeObject(allAttendanceRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"))) {
            allStudents = (List<Student>) in.readObject();
            allCourses = (List<Course>) in.readObject();
            allAttendanceRecords = (List<AttendanceRecord>) in.readObject();
        } catch (FileNotFoundException e) {

            allStudents = new ArrayList<>();
            allCourses = new ArrayList<>();
            allAttendanceRecords = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
