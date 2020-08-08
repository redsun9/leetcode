package leetcode.leetcode8xx.leetcode823;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        int[] a = {2, 4};
        assertEquals(3, new Solution().numFactoredBinaryTrees(a));
    }

    @Test
    void test2() {
        int[] a = {2, 4, 5, 10};
        assertEquals(7, new Solution().numFactoredBinaryTrees(a));
    }
}
