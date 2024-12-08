class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    double calculateGrossSalary() {
        double hra = salary * 0.2;
        double allowances = salary * 0.1;
        return salary + hra + allowances;
    }

    void applyBonus(double bonus) {
        salary += bonus;
    }

    void printSalaryDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 101, 30000);
        Employee employee2 = new Employee("Jane", 102, 35000);

        System.out.println("Before Bonus:");
        employee1.printSalaryDetails();
        employee2.printSalaryDetails();

        employee1.applyBonus(2000);
        employee2.applyBonus(2500);

        System.out.println("\nAfter Bonus:");
        employee1.printSalaryDetails();
        employee2.printSalaryDetails();

        System.out.println("\nGross Salary for Employee 1: " + employee1.calculateGrossSalary());
        System.out.println("Gross Salary for Employee 2: " + employee2.calculateGrossSalary());
    }
}
