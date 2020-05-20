package leetcode.leetcode7xx.leetcode768;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {5, 4, 3, 2, 1};
        assertEquals(1, new Solution().maxChunksToSorted(a));
    }
}