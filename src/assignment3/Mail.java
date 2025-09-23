package assignment3;

public class Mail {
    private static int nextId = 0;

    private final String deliveryAddress;
    private final String returnAddress;
    private final double width;
    private final double height; //length
    private final int id;

    public Mail(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double height
    ) {
        this.deliveryAddress = deliveryAddress;
        this.returnAddress = returnAddress;
        this.width = width;
        this.height = height;
        this.id = nextId++;
    }

    public Mail() {
        this("", "", 0, 0);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "%d%n" +
                        "%s%n" +
                        "%s%n",
                id, deliveryAddress, returnAddress
        );
    }
}
