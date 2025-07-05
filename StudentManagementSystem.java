import java.util.*;
import java.io.*;

public class StudentManagementSystem {

    // Student class
    static class Student {
        private String name;
        private String rollNumber;
        private String grade;

        public Student(String name, String rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String toString() {
            return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
        }
    }

    // List to store student records
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    // Load student data from file
    public void loadFromFile() {
        try {
            Scanner fileScanner = new Scanner(new File(FILE_NAME));
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                if (data.length == 3) {
                    students.add(new Student(data[0], data[1], data[2]));
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

    // Save student data to file
    public void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(FILE_NAME);
            for (Student s : students) {
                writer.println(s.getName() + "," + s.getRollNumber() + "," + s.getGrade());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Add new student
    public void addStudent(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        if (name.isEmpty() || roll.isEmpty() || grade.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("Student added successfully.");
    }

    // Remove student
    public void removeStudent(Scanner scanner) {
        System.out.print("Enter Roll Number to remove: ");
        String roll = scanner.nextLine();

        Student student = findByRoll(roll);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search for student
    public void searchStudent(Scanner scanner) {
        System.out.print("Enter Roll Number to search: ");
        String roll = scanner.nextLine();

        Student student = findByRoll(roll);
        if (student != null) {
            System.out.println("Details: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("List of Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Edit student data
    public void editStudent(Scanner scanner) {
        System.out.print("Enter Roll Number to edit: ");
        String roll = scanner.nextLine();

        Student student = findByRoll(roll);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new Name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new Grade (leave blank to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) {
            student.setGrade(grade);
        }

        System.out.println("Student updated.");
    }

    // Find student by roll number
    private Student findByRoll(String roll) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(roll)) {
                return s;
            }
        }
        return null;
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        sms.loadFromFile();

        int choice = 0;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    sms.addStudent(scanner);
                    break;
                case 2:
                    sms.editStudent(scanner);
                    break;
                case 3:
                    sms.removeStudent(scanner);
                    break;
                case 4:
                    sms.searchStudent(scanner);
                    break;
                case 5:
                    sms.displayAllStudents();
                    break;
                case 6:
                    sms.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
