import java.util.ArrayList;
import java.util.Scanner;

interface Department {
    String deptName = "Computer Science";
    String deptHead = "Dr. Sharma";
    void printDepartment();
}

class Hostel {
    String hostelName;
    String hostelLocation;
    int numberOfRooms;

    void setHostel(String hName, String hLoc, int rooms) {
        hostelName = hName;
        hostelLocation = hLoc;
        numberOfRooms = rooms;
    }

    void printHostel() {
        System.out.println("Hostel Name     : " + hostelName);
        System.out.println("Hostel Location : " + hostelLocation);
        System.out.println("Rooms           : " + numberOfRooms);
    }
}

class Student extends Hostel implements Department {
    String studentName;
    String regdNo;
    String electiveSubject;
    double avgMarks;

    void getData(Scanner sc) {
        System.out.print("Enter Registration No: ");
        regdNo = sc.next();
        System.out.print("Enter Student Name   : ");
        studentName = sc.next();
        System.out.print("Enter Elective Subject: ");
        electiveSubject = sc.next();
        System.out.print("Enter Average Marks  : ");
        avgMarks = sc.nextDouble();
        
        System.out.print("Enter Hostel Name    : ");
        String hName = sc.next();
        System.out.print("Enter Hostel Location: ");
        String hLoc = sc.next();
        System.out.print("Enter Rooms Count    : ");
        int rooms = sc.nextInt();
        
        setHostel(hName, hLoc, rooms);
    }

    void printData() {
        System.out.println("----------------------------------------");
        System.out.println("Registration No : " + regdNo);
        System.out.println("Student Name    : " + studentName);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks   : " + avgMarks);
        printDepartment();
        printHostel();
        System.out.println("----------------------------------------");
    }

    public void printDepartment() {
        System.out.println("Department Name : " + deptName);
        System.out.println("Department Head : " + deptHead);
    }
}

public class CollegeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- COLLEGE MANAGEMENT MENU ---");
            System.out.println("i) Admit new student");
            System.out.println("ii) Migrate a student");
            System.out.println("iii) Display details");
            System.out.println("iv) Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.getData(sc);
                    students.add(s);
                    System.out.println("Student admitted successfully!");
                    break;

                case 2:
                    System.out.print("Enter Registration Number to search & migrate: ");
                    String targetReg = sc.next();
                    boolean found = false;
                    for (Student st : students) {
                        if (st.regdNo.equalsIgnoreCase(targetReg)) {
                            System.out.print("Enter New Hostel Name: ");
                            String newHName = sc.next();
                            System.out.print("Enter New Hostel Location: ");
                            String newHLoc = sc.next();
                            System.out.print("Enter New Rooms Count: ");
                            int newRooms = sc.nextInt();
                            st.setHostel(newHName, newHLoc, newRooms);
                            System.out.println("Student migrated to new hostel successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with Regd No " + targetReg + " not found!");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n=== ALL STUDENT DETAILS ===");
                        for (Student st : students) {
                            st.printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
        
        sc.close();
    }
}