package leetcode.leetcode4xx.leetcode474;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        assertEquals(4, new Solution().findMaxForm(strs, m, n));
    }

    @Test
    void test2() {
        String[] strs = {"10", "0", "1"};
        int m = 1, n = 1;
        assertEquals(2, new Solution().findMaxForm(strs, m, n));
    }
}