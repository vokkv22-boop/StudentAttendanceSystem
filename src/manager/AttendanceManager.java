package manager;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager {

    private List<AttendanceRecord> records = new ArrayList<>();

    public void markAttendance(Student student, Course course, AttendanceStatus status) {
        records.add(new AttendanceRecord(student, course, status));
    }

    public void showAttendance() {
        for (AttendanceRecord record : records) {
            System.out.println(record);
        }
    }
}
