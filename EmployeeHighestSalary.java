import java.util.Scanner;

class Employee {
    int emp_no;
    String name;
    String department;
    double basic_pay;
    double DA;
    double HRA;
    double gross_salary;
    void calculateSalary() {
        DA = 0.40 * basic_pay;
        HRA = 0.20 * basic_pay;
        gross_salary = basic_pay + DA + HRA;
    }
    void displayDetails() {
        System.out.println("Employee Number : " + emp_no);
        System.out.println("Name            : " + name);
        System.out.println("Department      : " + department);
        System.out.println("Basic Pay       : " + basic_pay);
        System.out.println("DA              : " + DA);
        System.out.println("HRA             : " + HRA);
        System.out.println("Gross Salary    : " + gross_salary);
    }
}

public class EmployeeHighestSalary 
{
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        Employee[] empList = new Employee[n];
        Employee highestPaid = null;
        double maxGrossSalary = -1;

        for (int i = 0; i < n; i++) 
        {
            empList[i] = new Employee();
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            
            System.out.print("Enter Employee No: ");
            empList[i].emp_no = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            empList[i].name = sc.nextLine();

            System.out.print("Enter Department: ");
            empList[i].department = sc.nextLine();

            System.out.print("Enter Basic Pay: ");
            empList[i].basic_pay = sc.nextDouble();
            empList[i].calculateSalary();

            if (empList[i].gross_salary > maxGrossSalary) {
                maxGrossSalary = empList[i].gross_salary;
                highestPaid = empList[i];
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Employee with the Highest Gross Salary:");
        System.out.println("----------------------------------------");
        if (highestPaid != null) {
            highestPaid.displayDetails();
        }

        sc.close();
    }
}
