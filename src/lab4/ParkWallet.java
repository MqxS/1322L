package lab4;

public class ParkWallet {
    private static boolean holiday = false;

    private int tickets;

    public ParkWallet(final int tickets) {
        this.tickets = tickets;
    }

    public ParkWallet() {
        this(0);
    }

    public void addTickets(final int tickets) {
        if (tickets > 0) {
            this.tickets += tickets;
        }
    }

    public boolean removeTickets(final int tickets) {
        if (tickets > 0 && this.tickets >= tickets) {
            this.tickets -= tickets;
            return true;
        }
        return false;
    }

    public void setTickets(final int tickets) {
        if (tickets >= 0) {
            this.tickets = tickets;
        }
    }

    public static void setHoliday(final boolean holiday) {
        ParkWallet.holiday = holiday;
    }

    public static boolean getHoliday() {
        return holiday;
    }

    public int getTickets() {
        return tickets;
    }
}
