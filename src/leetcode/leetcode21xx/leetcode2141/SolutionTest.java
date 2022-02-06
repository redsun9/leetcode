package leetcode.leetcode21xx.leetcode2141;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 2;
        int[] batteries = {3, 3, 3};
        assertEquals(4, new Solution().maxRunTime(n, batteries));
    }

    @Test
    void test2() {
        int n = 2;
        int[] batteries = {1, 1, 1, 1};
        assertEquals(2, new Solution().maxRunTime(n, batteries));
    }

    @Test
    void test3() {
        int n = 3;
        int[] batteries = {10, 10, 3, 5};
        assertEquals(8, new Solution().maxRunTime(n, batteries));
    }

}