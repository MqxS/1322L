package lab5;

public class Checking extends Account {
    public Checking(final double accountBalance) {
        super(accountBalance);
    }

    @Override
    public double withdraw(final double amount) {
        final double balance = super.withdraw(amount);
        if (balance < 0) {
            System.out.println("Charing an overdraft fee of $20 because account is below $0");
            return super.withdraw(20);
        }
        return balance;
    }

    @Override
    public String toString() {
        return String.format(
                "Checking Account #%d, balance $%.2f",
                getAccountNumber(),
                getAccountBalance()
        );
    }
}
