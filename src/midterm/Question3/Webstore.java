package midterm.Question3;

public class Webstore extends Business {
    private final int clientsPerMonth;

    public Webstore(
            final String name,
            final double income,
            final double expenses,
            final int clientsPerMonth
    ) {
        super(name, income, expenses);
        this.clientsPerMonth = Math.max(clientsPerMonth, 0);
    }

    @Override
    public double getProfit() {
        return super.getProfit() - (clientsPerMonth * 0.05);
    }

    @Override
    public String toString() {
        return String.format("Webstore:%nName: %s | Monthly profit: $%.2f", getName(), getProfit());
    }
}
