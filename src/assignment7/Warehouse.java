package assignment7;

import java.util.ArrayList;

public class Warehouse {
    private final ArrayList<Produce> storage;
    private double taxSavings;
    public int tomatoesSold; //TODO: Modifying these directly in the threads is NOT thread safe.
    public int lettuceSold;
    public int carrotsSold;

    public Warehouse() {
        this.storage = new ArrayList<>();
        this.taxSavings = 0;
    }

    public synchronized void storeProduce(final Produce produce) {
        storage.add(produce);
    }

    public synchronized Produce getProduce() {
        if (storage.isEmpty()) {
            return null;
        }
        return storage.removeFirst();
    }

    public synchronized void addTomato() {
        tomatoesSold++;
    }

    public synchronized void addLettuce() {
        lettuceSold++;
    }

    public synchronized void addCarrot() {
        carrotsSold++;
    }

    public synchronized void addToTaxSavings(final double taxSavings) {
        this.taxSavings += taxSavings;
    }

    public synchronized double getTaxSavings() {
        return taxSavings;
    }
}
