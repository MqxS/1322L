package assignment3;

public class Flat extends Envelope {
    private final String contents;

    public Flat(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double length,
            final double thickness,
            final String contents
    ) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.contents = contents;
    }

    public Flat() {
        this("", "", 0, 0, 0, "");
    }

    public String getContents() {
        return contents;
    }
}
