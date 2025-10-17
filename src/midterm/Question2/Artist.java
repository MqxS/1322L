package midterm.Question2;

public class Artist {
    private final String name;
    private final double monthlyFee;

    public Artist(final String name, final double monthlyFee) {
        this.name = name;
        this.monthlyFee = Math.max(monthlyFee, 0);
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Monthly fee: $%.2f", name, monthlyFee);
    }
}
