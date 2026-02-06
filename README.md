# Student Attendance System

**Course:** Object-Oriented Programming (Java)  
**Project Type:** Educational Management System  
**Year:** 2026

## Team Members
- **Alua** 
- **Nurdaulet** 
- **Adele** 



## Project Description
The Student Attendance System is a **Java 17-based application** designed to automate and simplify tracking of student attendance in educational institutions.  
The system replaces traditional paper-based methods with a **digital solution** that stores attendance data in a structured, reliable, and easily accessible format.

**Primary goals:**
- Help teachers manage attendance efficiently
- Minimize human errors (missing or duplicate records)
- Improve transparency and accessibility of attendance information

Students have **view-only access** to their attendance records, while teachers and administrators can track attendance by student, course, or date.  
The project uses a **modular object-oriented architecture**, making it easy to extend and maintain.

## Technologies
- **Java 17**
- **IntelliJ IDEA (2023+)**
- **MySQL 8.0**
- Object-Oriented Programming (OOP) principles
- Git & GitHub for version control

## Project Structure and Classes
- **User** – base class for all system users
- **Student** – extends User, represents students
- **Teacher** – extends User, represents teachers
- **Course** – represents academic courses and manages relationships
- **AttendanceRecord** – stores attendance information for individual sessions
- **AttendanceManager** – handles attendance operations (marking, retrieving)
- **MenuManager** – manages user interaction and system navigation



## Minimum Viable Product (MVP) Features
- Add students and store their profiles
- Add courses and assign them to teachers
- Assign students to courses
- Mark attendance for each class session
- View attendance history by student or course
- Save and load attendance data (file I/O and database persistence)

## Future Improvements
- Deleting and updating students and courses
- Generating detailed attendance reports by student, course, or date range
- Sorting and filtering attendance data
- Implementing authentication and role-based access control
- Developing a graphical user interface (GUI)
- Integrating with cloud databases or web-based platforms

## How to Run
1. Open the project in **IntelliJ IDEA**
2. Run the `MenuManager.java` class
3. Follow the menu to interact with the system

