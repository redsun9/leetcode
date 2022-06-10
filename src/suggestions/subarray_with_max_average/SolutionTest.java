package suggestions.subarray_with_max_average;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void test1() {
        int[] arr = {1, 12, -5, -6, 50, 3};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] expected = solution2.maxAverage(arr, 2);
        int[] actual = solution.maxAverage(arr, 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] arr = {1, 12, 10, -6, 50, 3};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] expected = solution2.maxAverage(arr, 3);
        int[] actual = solution.maxAverage(arr, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int n = 100, minL = 10, minVal = -100, maxVal = 100;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertTrue(StressTester.constructionStressTest(
                (seed) -> {
                    int[] arr = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) arr[i] = random.nextInt(maxVal - minVal + 1) + minVal;
                    return arr;
                },
                arr -> solution.maxAverage(arr, minL),
                (arr, actual) -> {
                    if (actual == null || actual.length != 2) return false;
                    if (actual[0] < 0 || actual[1] <= actual[0] || actual[1] > n) return false;
                    if (actual[1] - actual[0] < minL) return false;
                    long sum = 0;
                    for (int i = actual[0]; i < actual[1]; i++) sum += arr[i];

                    int[] expected = solution2.maxAverage(arr, minL);
                    long expectedSum = 0;
                    for (int i = expected[0]; i < expected[1]; i++) expectedSum += arr[i];
                    return sum * (expected[1] - expected[0]) == expectedSum * (actual[1] - actual[0]);
                },
                10_000_000,
                1,
                1_000_000
        ));
    }
}