package leetcode.leetcode19xx.leetcode1986;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] tasks = {1, 2, 3};
        int sessionTime = 3, expected = 2;
        assertEquals(expected, new Solution().minSessions(tasks, sessionTime));
    }

    @Test
    void test2() {
        int[] tasks = {3, 1, 3, 1, 1};
        int sessionTime = 8, expected = 2;
        assertEquals(expected, new Solution().minSessions(tasks, sessionTime));
    }

    @Test
    void test3() {
        int[] tasks = {1, 2, 3, 4, 5};
        int sessionTime = 15, expected = 1;
        assertEquals(expected, new Solution().minSessions(tasks, sessionTime));
    }
}