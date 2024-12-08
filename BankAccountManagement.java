import java.util.ArrayList;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Initial deposit: " + initialDeposit);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposited " + amount + ". Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: " + amount);
                System.out.println("Withdrew " + amount + ". Current Balance: " + balance);
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create two bank accounts with initial deposits
        BankAccount account1 = new BankAccount("123456789", "John Doe", 1000);
        BankAccount account2 = new BankAccount("987654321", "Jane Smith", 500);

        // Perform some transactions on account1
        account1.deposit(200);
        account1.withdraw(150);
        account1.checkBalance();
        account1.displayTransactionHistory();

        System.out.println();

        // Perform some transactions on account2
        account2.deposit(100);
        account2.withdraw(700);
        account2.checkBalance();
        account2.displayTransactionHistory();
    }
}
