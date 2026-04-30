//Program : Student Grade Manager

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String name;
    double marks;
    String grade;

    Student(String name, double marks) {

        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Method to calculate grade
    String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A";
        }
        else if (marks >= 80) {
            return "B";
        }
        else if (marks >= 70) {
            return "C";
        }
        else if (marks >= 60) {
            return "D";
        }
        else {
            return "F";
        }
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input student data
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        // Variables for calculations
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        // Report
        System.out.println("\n===== STUDENT REPORT =====");

        for (Student s : students) {

            System.out.println("Name: " + s.name +
                    " | Marks: " + s.marks +
                    " | Grade: " + s.grade);

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        double average = total / students.size();

        System.out.println("\nAverage Marks: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        sc.close();
    }
}