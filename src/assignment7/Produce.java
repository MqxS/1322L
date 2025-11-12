package assignment7;

public class Produce {
    private final String produceName;
    private final double price;

    public Produce(final String produceName, final double price) {
        this.produceName = produceName;
        this.price = price;
    }

    public synchronized String getProduceName() {
        return produceName;
    }

    public synchronized double getPrice() {
        return price;
    }
}
