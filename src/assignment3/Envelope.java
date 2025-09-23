package assignment3;

public class Envelope extends Mail {
    private final double thickness;

    public Envelope(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double length,
            final double thickness
    ) {
        super(deliveryAddress, returnAddress, width, length);
        this.thickness = thickness;
    }

    public Envelope() {
        this("", "", 0, 0, 0);
    }

    public double getThickness() {
        return thickness;
    }

    @Override
    public String toString() {
        return String.format(
                "%s" +
                        "%.1f x %.1f x %.1f%n",
                super.toString(), getWidth(), getHeight(), getThickness()
        );
    }
}
