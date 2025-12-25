package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n=== LearnTrack Menu ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Manage Enrollments");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manageStudents(scanner, studentService);
                    break;
                case 2:
                    manageCourses(scanner, courseService);
                    break;
                case 3:
                    manageEnrollments(scanner, enrollmentService, studentService, courseService);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void manageStudents(Scanner scanner, StudentService service) {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        System.out.print("Choose option: ");
        int option = Integer.parseInt(scanner.nextLine());

        try {
            switch (option) {
                case 1:
                    System.out.print("First Name: "); String fn = scanner.nextLine();
                    System.out.print("Last Name: "); String ln = scanner.nextLine();
                    System.out.print("Email: "); String email = scanner.nextLine();
                    System.out.print("Batch: "); String batch = scanner.nextLine();
                    Student s = service.addStudent(fn, ln, email, batch);
                    System.out.println("Added Student ID: " + s.getId());
                    break;
                case 2:
                    List<Student> students = service.getAllStudents();
                    for (Student st : students) System.out.println(st.getDisplayName() + " [ID:" + st.getId() + "]");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = Integer.parseInt(scanner.nextLine());
                    Student st = service.getStudentById(sid);
                    System.out.println(st.getDisplayName() + " Active: " + st.isActive());
                    break;
                case 4:
                    System.out.print("Enter Student ID to deactivate: ");
                    int did = Integer.parseInt(scanner.nextLine());
                    boolean res = service.deactivateStudent(did);
                    System.out.println(res ? "Student deactivated" : "Student was already inactive");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void manageCourses(Scanner scanner, CourseService service) {
        System.out.println("\n--- Course Menu ---");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Activate Course");
        System.out.println("4. Deactivate Course");
        System.out.print("Choose option: ");
        int option = Integer.parseInt(scanner.nextLine());

        try {
            switch (option) {
                case 1:
                    System.out.print("Course Name: "); String name = scanner.nextLine();
                    System.out.print("Description: "); String desc = scanner.nextLine();
                    System.out.print("Duration in weeks: "); int dur = Integer.parseInt(scanner.nextLine());
                    Course c = service.addCourse(name, desc, dur);
                    System.out.println("Added Course ID: " + c.getId());
                    break;
                case 2:
                    List<Course> courses = service.getAllCourses();
                    for (Course co : courses)
                        System.out.println(co.getCourseName() + " [ID:" + co.getId() + "] Status: " + co.getStatus());
                    break;
                case 3:
                    System.out.print("Enter Course ID to activate: ");
                    int aid = Integer.parseInt(scanner.nextLine());
                    boolean ares = service.activateCourse(aid);
                    System.out.println(ares ? "Course activated" : "Already active");
                    break;
                case 4:
                    System.out.print("Enter Course ID to deactivate: ");
                    int did = Integer.parseInt(scanner.nextLine());
                    boolean dres = service.deactivateCourse(did);
                    System.out.println(dres ? "Course deactivated" : "Already inactive");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void manageEnrollments(Scanner scanner, EnrollmentService service, StudentService studentService, CourseService courseService) {
        System.out.println("\n--- Enrollment Menu ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Enrollments for Student");
        System.out.println("3. Update Enrollment Status");
        System.out.print("Choose option: ");
        int option = Integer.parseInt(scanner.nextLine());

        try {
            switch (option) {
                case 1:
                    System.out.print("Student ID: "); int sid = Integer.parseInt(scanner.nextLine());
                    studentService.getStudentById(sid); // check existence
                    System.out.print("Course ID: "); int cid = Integer.parseInt(scanner.nextLine());
                    courseService.getCourseById(cid); // check existence
                    service.enrollStudent(sid, cid);
                    System.out.println("Enrollment successful");
                    break;
                case 2:
                    System.out.print("Student ID: "); int sid2 = Integer.parseInt(scanner.nextLine());
                    List<?> enrollments = service.getEnrollmentsByStudent(sid2);
                    for (Object e : enrollments) System.out.println(e);
                    break;
                case 3:
                    System.out.print("Enrollment ID: "); int eid = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Status (ACTIVE, COMPLETED, CANCELLED): ");
                    EnrollmentStatus status = EnrollmentStatus.valueOf(scanner.nextLine().toUpperCase());
                    service.updateStatus(eid, status);
                    System.out.println("Status updated");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

