package lab5;

public class Account {
    private static int nextNumber = 10001;
    private final int accountNumber;
    private double accountBalance;

    public Account(final double accountBalance) {
        this.accountNumber = nextNumber++;
        this.accountBalance = accountBalance;
    }

    public Account() {
        this(0.0);
    }

    public double withdraw(final double amount) {
        this.accountBalance -= amount;
        return accountBalance;
    }

    public double deposit(final double amount) {
        this.accountBalance += amount;
        return accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return String.format("Account #%s, balance $%.2f", accountNumber, accountBalance);
    }
}
