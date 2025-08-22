package wiremetrics.in;

import java.util.*;

public class AdminService {
    private StudentDAO dao = new StudentDAO();

    public void addStudent(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, rollNo, dept, email, phone, marks);
        dao.addStudent(student);
    }

    public void viewStudents() {
        List<Student> list = dao.getAllStudents();
        System.out.printf("%-5s %-15s %-10s %-15s %-25s %-15s %-5s%n", 
            "ID", "Name", "Roll No", "Department", "Email", "Phone", "Marks");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Enter Roll No of student to update: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter New Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, rollNo, dept, email, phone, marks);
        dao.updateStudent(rollNo, student);
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Enter Roll No of student to delete: ");
        String rollNo = sc.nextLine();
        dao.deleteStudent(rollNo);
    }

    public void searchStudent(Scanner sc) {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();
        List<Student> list = dao.searchByName(name);
        for (Student s : list) {
            System.out.println(s);
        }
    }
}