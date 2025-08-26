package lab6;

public class FibFormula implements FindFib {
    @Override
    public int calculateFib(final int n) {
        final double phi = (1 + Math.sqrt(5)) / 2.0;
        final double psi = (1 - Math.sqrt(5)) / 2.0;
        final double numerator = Math.pow(phi, n) - Math.pow(psi, n);
        final double fibN = numerator / Math.sqrt(5);
        return (int) fibN;
    }
}
