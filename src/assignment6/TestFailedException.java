package assignment6;

public class TestFailedException extends Exception {
    private final Sample sample;

    public TestFailedException(final String message, final Sample sample) {
        super(message);
        this.sample = sample;
    }

    public Sample getSample() {
        return sample;
    }
}
