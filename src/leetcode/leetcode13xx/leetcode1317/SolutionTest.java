package leetcode.leetcode13xx.leetcode1317;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void getNoZeroIntegers() {
        Solution solution = new Solution();
        for (int i = 2; i < 100000; i++) {
            int[] ans = solution.getNoZeroIntegers(i);
            assertEquals(-1, Integer.toString(ans[0]).indexOf('0'));
            assertEquals(-1, Integer.toString(ans[1]).indexOf('0'));
        }
    }
}