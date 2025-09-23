package assignment3;

public class Box extends Mail {
    private final double height;
    private int count;

    public Box(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double length,
            final double height,
            final int count
    ) {
        super(deliveryAddress, returnAddress, width, length);
        this.height = height;
        this.count = count;
    }

    public Box() {
        this("", "", 0, 0, 0, 0);
    }

    public double getBoxHeight() {
        return height;
    }
    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format(
                "%s" +
                        "%.1f x %.1f x %.1f%n",
                super.toString(), getWidth(), getHeight(), getBoxHeight()
        );
    }
}
