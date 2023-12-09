package basic.utils;

public class Interpolation {
    private Interpolation() {
    }

    public static double interpolateLagrange(double[] xi, double[] yi, double x) {
        double result = 0; // Initialize result
        int n = xi.length;

        for (int i = 0; i < n; i++) {
            // Compute individual terms of above formula
            double term = yi[i];
            for (int j = 0; j < n; j++) if (j != i) term = term * (x - xi[j]) / (xi[i] - xi[j]);

            // Add current term to result
            result += term;
        }
        return result;
    }
}
