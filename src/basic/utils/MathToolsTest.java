package basic.utils;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathToolsTest {

    @Test
    void findRootTest1() {
        DoubleFunction<Double> f = x -> x - Math.cos(x);
        double expected = 0.73908_51332_15160_64165;
        assertEquals(expected, MathTools.findRoot(f, 0, 1), 1e-15);
    }

    @Test
    void findRootTest2() {
        DoubleFunction<Double> f = x -> x * x * x - x - 1;
        double expected = 1.32471_79572_44746_02596;
        assertEquals(expected, MathTools.findRoot(f, 0, 2), 1e-15);
    }

    @Test
    void findMinimumTest1() {
        DoubleFunction<Double> f1 = x -> (x - 1) * (x - 1);
        double expected = 1;
        assertEquals(expected, MathTools.findMinimum(f1, -1, 2), 1e-15);
    }

    @Test
    void findMaximumTest1() {
        DoubleFunction<Double> f1 = Math::cos;
        double expected = 0;
        assertEquals(expected, MathTools.findMaximum(f1, -1, 2), 1e-6);
    }
}