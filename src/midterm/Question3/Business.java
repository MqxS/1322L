package midterm.Question3;

public class Business {
    private final String name;
    private final double income;

    private final double expenses;

    public Business(final String name, final double income, final double expenses) {
        this.name = name;
        this.income = Math.max(income, 0);
        this.expenses = Math.max(expenses, 0);
    }

    public double getProfit() {
        return income - expenses;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Monthly profit $%.2f", name, getProfit());
    }
}
