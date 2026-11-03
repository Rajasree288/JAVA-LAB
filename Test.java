interface Bank {
    void showBank();
}

// 2. Superclass
class Customer {
    String name = "Alice";
}
class Account extends Customer implements Bank {
    int accNumber = 12345;

    public void showBank() {
        System.out.println("Bank Name: City Bank");
    }

    void display() {
        showBank();
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accNumber);
    }
}

public class Test {
    public static void main(String[] args) {
        Account a = new Account();
        a.display();
    }
}