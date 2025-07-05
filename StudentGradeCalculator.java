import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalSubjects = 5;
        int[] marks = new int[totalSubjects];
        int totalMarks = 0;

        // Getting marks from user
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            int input = scanner.nextInt();

            // Check if marks are valid
            if (input >= 0 && input <= 100) {
                marks[i] = input;
                totalMarks += input;
            } else {
                System.out.println("Invalid marks. Please enter between 0 and 100.");
                i--; // repeat the same subject
            }
        }

        // Calculate average percentage
        double percentage = totalMarks / (double) totalSubjects;

        // Find grade
        String grade;

        if (percentage >= 95) {
            grade = "O";
        } else if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 85) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B+";
        } else if (percentage >= 75) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display results
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks + " out of 500");
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
