package lab5;

public class Saving extends Account {
    private int numberOfDeposits = 0;

    public Saving(final double accountBalance) {
        super(accountBalance);
    }

    @Override
    public double withdraw(final double amount) {
        final double balance = super.withdraw(amount);
        if (balance < 500) {
            System.out.println("Charing a fee of $10 because you are below $500");
            return super.withdraw(10);
        }
        return balance;
    }

    @Override
    public double deposit(final double amount) {
        final double balance = super.deposit(amount);
        numberOfDeposits++;
        System.out.printf("This is deposit %d to this account%n", numberOfDeposits);
        if (numberOfDeposits > 5) {
            System.out.println("Charging a fee of $10");
            return super.withdraw(10);
        }
        return balance;
    }

    public double addInterest() {
        final double interest = getAccountBalance() * 0.015;
        System.out.printf("Customer earned $%.2f in interest%n", interest);
        return super.deposit(interest);
    }

    @Override
    public String toString() {
        return String.format(
                "Saving Account #%d, balance $%.2f",
                getAccountNumber(),
                getAccountBalance()
        );
    }
}
