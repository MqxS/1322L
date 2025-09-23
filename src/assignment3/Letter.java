package assignment3;

public class Letter extends Envelope {
    private final String letterBody;

    public Letter(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double length,
            final double thickness,
            final String letterBody
    ) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.letterBody = letterBody;
    }

    public Letter() {
        this("", "", 0, 0, 0, "");
    }

    public String getLetterBody() {
        return letterBody;
    }
}
