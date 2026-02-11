package gui;

import manager.AttendanceManager;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class MainFrame extends JFrame {

    private AttendanceManager attendanceManager = new AttendanceManager();

    private DefaultTableModel studentTableModel;
    private JTable studentTable;

    private DefaultTableModel courseTableModel;
    private JTable courseTable;

    private DefaultTableModel attendanceTableModel;
    private JTable attendanceTable;

    public MainFrame() {
        setTitle("Student Attendance System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        attendanceManager.loadData();


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                attendanceManager.saveData();
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel studentPanel = new JPanel(new BorderLayout());
        String[] studentColumns = {"Name"};
        studentTableModel = new DefaultTableModel(studentColumns, 0);
        studentTable = new JTable(studentTableModel);
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        JPanel studentButtons = new JPanel();
        JButton addStudentBtn = new JButton("Add Student");
        JButton refreshStudentBtn = new JButton("Refresh");
        studentButtons.add(addStudentBtn);
        studentButtons.add(refreshStudentBtn);
        studentPanel.add(studentButtons, BorderLayout.SOUTH);

        addStudentBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter student name:");
            if (name != null && !name.isEmpty()) {
                Student s = new Student(attendanceManager.getAllStudents().size() + 1, name);
                attendanceManager.getAllStudents().add(s);
                attendanceManager.saveData();
                refreshStudentTable();
            }
        });

        refreshStudentBtn.addActionListener(e -> refreshStudentTable());
        tabbedPane.addTab("Students", studentPanel);


        JPanel coursePanel = new JPanel(new BorderLayout());
        String[] courseColumns = {"Name"};
        courseTableModel = new DefaultTableModel(courseColumns, 0);
        courseTable = new JTable(courseTableModel);
        coursePanel.add(new JScrollPane(courseTable), BorderLayout.CENTER);

        JPanel courseButtons = new JPanel();
        JButton addCourseBtn = new JButton("Add Course");
        JButton refreshCourseBtn = new JButton("Refresh");
        courseButtons.add(addCourseBtn);
        courseButtons.add(refreshCourseBtn);
        coursePanel.add(courseButtons, BorderLayout.SOUTH);

        addCourseBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter course name:");
            if (name != null && !name.isEmpty()) {
                Course c = new Course(name);
                attendanceManager.getAllCourses().add(c);
                attendanceManager.saveData();
                refreshCourseTable();
            }
        });

        refreshCourseBtn.addActionListener(e -> refreshCourseTable());
        tabbedPane.addTab("Courses", coursePanel);


        JPanel attendancePanel = new JPanel(new BorderLayout());
        String[] attendanceColumns = {"Student", "Course", "Status"};
        attendanceTableModel = new DefaultTableModel(attendanceColumns, 0);
        attendanceTable = new JTable(attendanceTableModel);
        attendancePanel.add(new JScrollPane(attendanceTable), BorderLayout.CENTER);

        JPanel attendanceButtons = new JPanel();
        JButton markAttendanceBtn = new JButton("Mark Attendance");
        JButton refreshAttendanceBtn = new JButton("Refresh");
        attendanceButtons.add(markAttendanceBtn);
        attendanceButtons.add(refreshAttendanceBtn);
        attendancePanel.add(attendanceButtons, BorderLayout.SOUTH);


        markAttendanceBtn.addActionListener(e -> {
            List<Student> students = attendanceManager.getAllStudents();
            List<Course> courses = attendanceManager.getAllCourses();
            if (students.isEmpty() || courses.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students or courses available");
                return;
            }


            Student student = students.get(JOptionPane.showOptionDialog(
                    this, "Select student", "Mark Attendance",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, students.toArray(), students.get(0)
            ));


            Course course = courses.get(JOptionPane.showOptionDialog(
                    this, "Select course", "Mark Attendance",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, courses.toArray(), courses.get(0)
            ));

            if (student != null && course != null) {

                AttendanceStatus[] statuses = AttendanceStatus.values();
                AttendanceStatus selectedStatus = (AttendanceStatus) JOptionPane.showInputDialog(
                        this,
                        "Select status",
                        "Mark Attendance",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        statuses,
                        statuses[0]
                );

                if (selectedStatus != null) {
                    attendanceManager.markAttendance(student, course, selectedStatus);
                    attendanceManager.saveData();
                    refreshAttendanceTable();
                }
            }
        });

        refreshAttendanceBtn.addActionListener(e -> refreshAttendanceTable());

        tabbedPane.addTab("Attendance", attendancePanel);

        add(tabbedPane);
        setVisible(true);


        refreshStudentTable();
        refreshCourseTable();
        refreshAttendanceTable();
    }

    private void refreshStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student s : attendanceManager.getAllStudents()) {
            studentTableModel.addRow(new Object[]{s.getName()});
        }
    }

    private void refreshCourseTable() {
        courseTableModel.setRowCount(0);
        for (Course c : attendanceManager.getAllCourses()) {
            courseTableModel.addRow(new Object[]{c.getName()});
        }
    }

    private void refreshAttendanceTable() {
        attendanceTableModel.setRowCount(0);
        for (AttendanceRecord r : attendanceManager.getAllAttendanceRecords()) {
            attendanceTableModel.addRow(new Object[]{
                    r.getStudent().getName(),
                    r.getCourse().getName(),
                    r.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
