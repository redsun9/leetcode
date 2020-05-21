package leetcode.leetcode11xx.leetcode1130;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {6, 2, 4};
        assertEquals(32, new Solution().mctFromLeafValues(a));
    }
}