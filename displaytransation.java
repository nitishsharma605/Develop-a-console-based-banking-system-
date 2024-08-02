import java.io.*;
import java.util.*;

// Account class
class Account {
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

// Customer class
class Customer {
    private String customerName;
    private String address;
    private String phoneNumber;

    public Customer(String customerName, String address, String phoneNumber) {
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Transaction class
class Transaction {
    private String transactionType;
    private double amount;
    private String accountNumber;

    public Transaction(String transactionType, double amount, String accountNumber) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// BankingSystem class
class BankingSystem {
    private Map<String, Account> accounts;
    private Map<String, Customer> customers;
    private List<Transaction> transactions;
    private Scanner scanner;

    public BankingSystem() {
        accounts = new HashMap<>();
        customers = new HashMap<>();
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Account account = new Account(accountNumber, customerName, balance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
    }

    public void createCustomer() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(customerName, address, phoneNumber);
        customers.put(customerName, customer);
        System.out.println("Customer created successfully.");
    }

    public void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            Transaction transaction = new Transaction("Deposit", amount, accountNumber);
            transactions.add(transaction);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            Transaction transaction = new Transaction("Withdrawal", amount, accountNumber);
            transactions.add(transaction);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayTransactions() {
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("Transaction type: " + transaction.getTransactionType());
           