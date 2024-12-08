import java.util.ArrayList;
import java.util.Collections;

class Student {
    String name;
    int id;
    ArrayList<Double> grades;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    double findHighestGrade() {
        return Collections.max(grades);
    }

    double findLowestGrade() {
        return Collections.min(grades);
    }

    void displayGradeReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverageGrade());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 101);
        student1.addGrade(85);
        student1.addGrade(92);
        student1.addGrade(78);

        Student student2 = new Student("Jane", 102);
        student2.addGrade(88);
        student2.addGrade(94);
        student2.addGrade(82);

        student1.displayGradeReport();
        System.out.println();
        student2.displayGradeReport();
    }
}
