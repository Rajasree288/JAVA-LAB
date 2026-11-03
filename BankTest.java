abstract class Accounts {
    double balance;
    String accountNumber;
    String accountHoldersName;
    String address;

    abstract void withdrawl(double amount);
    abstract void deposit(double amount);

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

class SavingsAccount extends Accounts {
    double rateOfInterest;

    public SavingsAccount(String accNum, String name, String addr, double initialBalance, double roi) {
        accountNumber = accNum;
        accountHoldersName = name;
        address = addr;
        balance = initialBalance;
        rateOfInterest = roi;
    }

    void withdrawl(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully Deposited: $" + amount);
    }

    void calculateAmount() {
        double interest = (balance * rateOfInterest) / 100;
        System.out.println("Calculated Interest (" + rateOfInterest + "%): $" + interest);
    }
}

public class BankTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC123", "John Smith", "New York", 5000.0, 4.5);

        sa.display();
        System.out.println();

        sa.deposit(1500.0);
        sa.withdrawl(1000.0);
        System.out.println();

        sa.calculateAmount();
        System.out.println();

        sa.display();
    }
}