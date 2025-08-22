package wiremetrics.in;

import java.util.*;

public class UI {
    private AdminService service = new AdminService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Welcome to SmartStudent =====");
        if (login(sc)) {
            int choice;
            do {
                showMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: service.addStudent(sc); break;
                    case 2: service.viewStudents(); break;
                    case 3: service.updateStudent(sc); break;
                    case 4: service.deleteStudent(sc); break;
                    case 5: service.searchStudent(sc); break;
                    case 0: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice!");
                }
            } while (choice != 0);
        }
        sc.close();
    }

    private boolean login(Scanner sc) {
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        if (user.equals("admin") && pass.equals("admin123")) {
            System.out.println("✅ Login successful!");
            return true;
        } else {
            System.out.println("❌ Invalid credentials!");
            return false;
        }
    }

    private void showMenu() {
        System.out.println("\n===== Admin Panel =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}