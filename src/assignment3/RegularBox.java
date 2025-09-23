package assignment3;

public class RegularBox extends Box {
    private final String items;
    private final double weight;

    public RegularBox(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double length,
            final double height,
            final int count,
            final String items,
            final double weight
    ) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.items = items;
        this.weight = weight;
    }

    public RegularBox() {
        this("", "", 0, 0, 0, 0, "", 0);
    }

    public String getItems() {
        return items;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format(
                "%s" +
                        "Items: %s%n" +
                        "Count: %d%n" +
                        "Weight: %.1f%n",
                super.toString(),
                getItems(),
                getCount(),
                getWeight()
        );
    }
}
