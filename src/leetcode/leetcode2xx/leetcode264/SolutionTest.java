package leetcode.leetcode2xx.leetcode264;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void nthUglyNumber() {
        int[] expected = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
        int[] actual = new int[10];
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            actual[i] = solution.nthUglyNumber(i + 1);
        }
        assertArrayEquals(expected, actual);
    }
}