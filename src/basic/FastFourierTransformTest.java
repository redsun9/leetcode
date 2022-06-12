package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

class FastFourierTransformTest {
    @Test
    void multiply() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] actual = FastFourierTransform.multiply(a, b);
        int[] expected = {4, 13, 28, 27, 18};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void modularMultiply() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] actual = FastFourierTransform.modularMultiply(a, b);
        int[] expected = {4, 13, 28, 27, 18};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testCorrectnessMultiply() throws InterruptedException {
        int minN = 1, maxN = 100, minValue = -100, maxValue = 100;
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int n = random.nextInt(maxN - minN + 1) + minN;
                    int m = random.nextInt(maxN - minN + 1) + minN;
                    int[] a = new int[n];
                    int[] b = new int[m];
                    for (int i = 0; i < n; i++) a[i] = random.nextInt(maxValue - minValue + 1) + minValue;
                    for (int i = 0; i < m; i++) b[i] = random.nextInt(maxValue - minValue + 1) + minValue;
                    return new int[][]{a, b};
                },
                data -> FastFourierTransform.multiply(data[0], data[1]),
                data -> dummyMultiply(data[0], data[1]),
                1_000_000,
                1,
                100_000
        );
    }

    @Test
    void testCorrectnessModularMultiply() throws InterruptedException {
        int minN = 1, maxN = 100, minValue = 0, maxValue = 100;
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int n = random.nextInt(maxN - minN + 1) + minN;
                    int m = random.nextInt(maxN - minN + 1) + minN;
                    int[] a = new int[n];
                    int[] b = new int[m];
                    for (int i = 0; i < n; i++) a[i] = random.nextInt(maxValue - minValue + 1) + minValue;
                    for (int i = 0; i < m; i++) b[i] = random.nextInt(maxValue - minValue + 1) + minValue;
                    return new int[][]{a, b};
                },
                data -> FastFourierTransform.modularMultiply(data[0], data[1]),
                data -> dummyMultiply(data[0], data[1]),
                1_000_000,
                1,
                100_000
        );
    }

    private static int[] dummyMultiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }
        return result;
    }
}