package leetcode.leetcode14xx.leetcode1498;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {3, 5, 6, 7};
        assertEquals(4, new Solution().numSubseq(a, 9));
    }

    @Test
    void test2() {
        int[] a = {3, 3, 6, 8};
        assertEquals(6, new Solution().numSubseq(a, 10));
    }

    @Test
    void test3() {
        int[] a = {2, 3, 3, 4, 6, 7};
        assertEquals(61, new Solution().numSubseq(a, 12));
    }

    @Test
    void test4() {
        int[] a = {5, 2, 4, 1, 7, 6, 8};
        assertEquals(127, new Solution().numSubseq(a, 16));
    }
}