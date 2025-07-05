import java.util.Scanner;

// Class to represent a Bank Account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// Class for ATM operations
class ATM {
    private BankAccount account;

    // Constructor to link bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display menu and perform operations
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                deposit(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                withdraw(amount);
            } else if (choice == 4) {
                System.out.println("Exiting... Thank you!");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your balance is: ₹" + account.getBalance());
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Amount withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// Main class
public class AtmInterface {
    public static void main(String[] args) {
        // Create bank account with ₹1000 balance
        BankAccount myAccount = new BankAccount(1000.0);

        // Create ATM object with the account
        ATM atm = new ATM(myAccount);

        // Show the ATM menu
        atm.showMenu();
    }
}
