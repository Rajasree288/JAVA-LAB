
interface Gross {
    double calculateGross();
}

class Employee {
    int emp_id;
    String name;
    double basic;

    void getDetails(int id, String n, double b) {
        emp_id = id;
        name = n;
        basic = b;
    }
}

class Salary extends Employee implements Gross {
    double hra, da, gross;

    public double calculateGross() {
        hra = basic * 0.20;
        da = basic * 0.10;
        gross = basic + hra + da;
        return gross;
    }

    void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Gross Salary: " + calculateGross());
    }
}

public class Main {
    public static void main(String[] args) {
        Salary s = new Salary();

        s.getDetails(101, "Riya", 30000);

        s.display();
    }
}
