package leetcode.leetcode9xx.leetcode952;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {4, 6, 15, 35};
        assertEquals(4, new Solution().largestComponentSize(a));
    }

    @Test
    void test2() {
        int[] a = {20, 50, 9, 63};
        assertEquals(2, new Solution().largestComponentSize(a));
    }

    @Test
    void test3() {
        int[] a = {2, 3, 6, 7, 4, 12, 21, 39};
        assertEquals(8, new Solution().largestComponentSize(a));
    }

}