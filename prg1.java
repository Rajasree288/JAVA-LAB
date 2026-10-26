class Employee 
{
    private String name;
    private String department;
    private double salary;
    private static String companyName = "Global Tech Solutions";
    public Employee(String name, String department, double salary)
     {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void displayInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("--------------------");
    }
}

public class prg1
 {
    public static void main(String[] args) 
    {
        Employee emp1 = new Employee("Alice Smith", "Engineering", 75000);
        Employee emp2 = new Employee("Bob Jones", "Marketing", 62000);
        Employee emp3 = new Employee("Charlie Brown", "Human Resources", 55000);
        Employee emp4 = new Employee("Diana Prince", "Finance", 82000);
        Employee emp5 = new Employee("Ethan Hunt", "Operations", 68000);
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
        emp4.displayInfo();
        emp5.displayInfo();
    }
}