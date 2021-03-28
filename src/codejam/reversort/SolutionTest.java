package codejam.reversort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static codejam.reverse_engineering.Solution.generateArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SolutionTest {

    @Test
    void test1() {
        for (int n = 2; n <= 100; n++) {
            for (int c = n - 1; c < n * (n + 1) / 2; c++) {
                int[] a = generateArray(n, c);
                assertNotNull(a);
                try {
                    assertEquals(Solution.countWeight(a), c);
                } catch (Throwable ex) {
                    System.out.println(n);
                    System.out.println(c);
                    System.out.println(Arrays.toString(a));
                    throw ex;
                }
            }
        }
    }

    @Test
    void test2() {
        int[] a = generateArray(3, 3);
        assertNotNull(a);
        assertEquals(Solution.countWeight(a), 3);
    }
}