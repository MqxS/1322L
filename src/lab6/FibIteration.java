package lab6;

public class FibIteration implements FindFib {
    @Override
    public int calculateFib(final int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = a + b;
            a = b;
            b = fibN;
        }
        return fibN;
    }
}
