package manager;

import model.*;
import java.util.Scanner;

public class MenuManager {

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(1, studentName);

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = new Course(courseName);

        System.out.println("Choose attendance status:");
        System.out.println("1 - PRESENT");
        System.out.println("2 - ABSENT");
        System.out.println("3 - LATE");
        System.out.println("4 - EXCUSED");

        int choice = scanner.nextInt();
        AttendanceStatus status;

        switch (choice) {
            case 1 -> status = AttendanceStatus.PRESENT;
            case 2 -> status = AttendanceStatus.ABSENT;
            case 3 -> status = AttendanceStatus.LATE;
            case 4 -> status = AttendanceStatus.EXCUSED;
            default -> status = AttendanceStatus.ABSENT;
        }

        AttendanceManager manager = new AttendanceManager();
        manager.markAttendance(student, course, status);

        System.out.println("\nAttendance record:");
        manager.showAttendance();
    }
}
