package help_requests.find_all_duplicates;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {3, 6, 6, 7, 10, 4, 8, 4, 4, 1};
        int[] expected = {4, 6};
        assertArrayEquals(expected, Solution.findAllDuplicates(arr, 2));
    }

    @Test
    void testRandom() throws InterruptedException {
        final int n = 100, k = 3;
        assertTrue(StressTester.exactStressTest(
                seed -> generate(n, seed),
                arr -> Solution.findAllDuplicates(Arrays.copyOf(arr, n), k),
                arr -> Solution2.findAllDuplicates(arr, k),
                1_000_000,
                1,
                100_000
        ));
    }

    private static int[] generate(int n, long seed) {
        Random random = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1 + random.nextInt(n);
        return arr;
    }
}