abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        setAccountNumber(accountNumber);
        setHolderName(holderName);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        setBalance(getBalance() - amount);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.printf("Balance: %.2f%n", getBalance());
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {

    private double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * getInterestRate() / 100;
    }
}

class CurrentAccount extends BankAccount {

    private double monthlyBonusRate;

    CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        setMonthlyBonusRate(monthlyBonusRate);
    }

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * getMonthlyBonusRate() / 100;
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SAV-101", "Rohan Verma", 25000, 4.5);
        CurrentAccount currentAccount = new CurrentAccount("CUR-201", "Ananya Rao", 40000, 1.2);

        savingsAccount.deposit(5000);
        savingsAccount.withdraw(3000);

        currentAccount.deposit(10000);
        currentAccount.withdraw(7000);

        savingsAccount.displayAccountDetails();
        System.out.printf("Calculated Interest: %.2f%n%n", savingsAccount.calculateInterest());

        currentAccount.displayAccountDetails();
        System.out.printf("Calculated Interest: %.2f%n", currentAccount.calculateInterest());
    }
}
