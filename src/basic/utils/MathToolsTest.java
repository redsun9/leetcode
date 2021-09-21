package basic.utils;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathToolsTest {

    @Test
    void dichotomyFindRootTest1() {
        DoubleFunction<Double> f = x -> x - Math.cos(x);
        double expected = 0.73908_51332_15160_64165;
        assertEquals(expected, MathTools.findRoot(f, 0, 1), 1e-15);
    }

    @Test
    void dichotomyFindRootTest2() {
        DoubleFunction<Double> f = x -> x * x * x - x - 1;
        double expected = 1.32471_79572_44746_02596;
        assertEquals(expected, MathTools.findRoot(f, 0, 2), 1e-15);
    }

    @Test
    void newtonFindRootTest1() {
        DoubleFunction<Double> f = x -> x - Math.cos(x);
        DoubleFunction<Double> df = x -> 1 + Math.sin(x);
        double expected = 0.73908_51332_15160_64165;
        assertEquals(expected, MathTools.findRoot(f, df, 0, 1e-15), 1e-15);
    }

    @Test
    void newtonFindRootTest2() {
        DoubleFunction<Double> f = x -> x * x * x - x - 1;
        DoubleFunction<Double> df = x -> 3 * x * x - 1;
        double expected = 1.32471_79572_44746_02596;
        assertEquals(expected, MathTools.findRoot(f, df, 0, 1e-15), 1e-15);
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