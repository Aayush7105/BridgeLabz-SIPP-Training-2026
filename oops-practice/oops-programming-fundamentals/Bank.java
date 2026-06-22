
class BankDemoAccount {

    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccountsCreated = 0;

    public BankDemoAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccountsCreated++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holder + " deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println(holder + ": Insufficient balance! Withdrawal of ₹" + amount + " failed.");
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew ₹" + amount);
        }
    }

    public void getStatement() {
        System.out.println("\n----- Account Statement -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holder);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("-----------------------------");
    }

    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }
}

public class Bank {

    public static void main(String[] args) {

        BankDemoAccount acc1 = new BankDemoAccount("101", "Rahul", 5000);
        BankDemoAccount acc2 = new BankDemoAccount("102", "Priya", 8000);
        BankDemoAccount acc3 = new BankDemoAccount("103", "Amit", 10000);

        acc1.deposit(1000);
        acc1.withdraw(700);
        acc1.deposit(500);
        acc1.withdraw(2000);
        acc1.withdraw(5000);
        acc2.withdraw(1000);
        acc2.deposit(1500);
        acc2.withdraw(2500);
        acc2.deposit(1000);
        acc2.withdraw(9000);

        acc3.deposit(3000);
        acc3.withdraw(4000);
        acc3.deposit(2000);
        acc3.withdraw(1500);
        acc3.withdraw(12000);

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal Accounts Created: "
                + BankDemoAccount.getTotalAccountsCreated());
    }
}
