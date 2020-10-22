package leetcode.leetcode9xx.leetcode977;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testRandom() {
        int n = 10000;
        int minVal = -10000;
        int maxVal = 10000;
        int diff = maxVal - minVal + 1;
        Random random = new Random(1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = minVal + random.nextInt(diff);
        int[] expected = new int[n];
        for (int i = 0; i < n; i++) expected[i] = arr[i] * arr[i];
        Arrays.sort(arr);
        Arrays.sort(expected);
        int[] actual = new Solution().sortedSquares(arr);
        assertArrayEquals(expected, actual);
    }
}