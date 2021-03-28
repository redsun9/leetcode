package leetcode.leetcode17xx.leetcode1723;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] jobs = {3, 2, 3};
        assertEquals(3, new Solution().minimumTimeRequired(jobs, 3));
    }

    @Test
    void test2() {
        int[] jobs = {1, 2, 4, 7, 8};
        assertEquals(11, new Solution().minimumTimeRequired(jobs, 2));
    }
}