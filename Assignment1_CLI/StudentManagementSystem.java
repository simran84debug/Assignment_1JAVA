import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // ===== Add Student =====
    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));

        System.out.println("Student Added Successfully!");
    }

    // ===== View Students =====
    static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No Records Found.");
            return;
        }

        for (Student s : students) {

            s.display();
        }
    }

    // ===== Update Student =====
    static void updateStudent() {

        System.out.print("Enter Student ID to Update: ");

        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.id == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Record Updated Successfully!");

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found.");
        }
    }

    // ===== Delete Student =====
    static void deleteStudent() {

        System.out.print("Enter Student ID to Delete: ");

        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.id == id) {

                students.remove(s);

                System.out.println("Record Deleted Successfully!");

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found.");
        }
    }

    // ===== Search Student =====
    static void searchStudent() {

        System.out.print("Enter Student ID to Search: ");

        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.id == id) {

                System.out.println("\nStudent Record Found:");
                System.out.println("---------------------");

                s.display();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found.");
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}