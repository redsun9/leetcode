package basic.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpolationTest {

    @Test
    void interpolateLagrange() {
        DoubleUnaryOperator f = x -> 5 * x * x * x * x - 3 * x * x + 11 * x - 1;

        int k = 10;
        double[] x = new double[k];
        double[] y = new double[k];

        Random random = new Random();
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            double u = random.nextDouble();
            while (set.contains(u)) u = random.nextDouble();
            set.add(u);

            x[i] = u;
            y[i] = f.applyAsDouble(u);
        }

        for (int i = 0; i < 1000; i++) {
            double t = random.nextDouble();
            while (set.contains(t)) t = random.nextDouble();

            double expected = f.applyAsDouble(t);
            double actual = Interpolation.interpolateLagrange(x, y, t);
            assertEquals(expected, actual, 1e-10);
        }
    }
}