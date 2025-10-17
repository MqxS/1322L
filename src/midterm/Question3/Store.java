package midterm.Question3;

public class Store extends Business {
    private final double rent;

    public Store(
            final String name,
            final double income,
            final double expenses,
            final double rent
    ) {
        super(name, income, expenses);
        this.rent = Math.max(rent, 0);
    }

    @Override
    public double getProfit() {
        return super.getProfit() - rent;
    }

    @Override
    public String toString() {
        return String.format("Store:%nName: %s | Monthly profit: $%.2f", getName(), getProfit());
    }
}
