package leetcode.leetcode19xx.leetcode1900;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        assertArrayEquals(new int[]{3, 4}, new Solution().earliestAndLatest(11, 2, 4));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{1, 1}, new Solution().earliestAndLatest(5, 1, 5));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{4, 4}, new Solution().earliestAndLatest(10, 1, 2));
    }

    @Test
    void test4() {
        assertArrayEquals(new int[]{2, 2}, new Solution().earliestAndLatest(4, 1, 3));
    }

    @Test
    void test5() {
        assertArrayEquals(new int[]{2, 2}, new Solution().earliestAndLatest(5, 1, 4));
    }

    @Test
    void test6() {
        assertArrayEquals(new int[]{3, 5}, new Solution().earliestAndLatest(18, 6, 12));
    }
}