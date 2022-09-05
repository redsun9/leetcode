package leetcode.leetcode24xx.leetcode2400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int startPos = 272, endPos = 270, k = 6;
        assertEquals(15, new Solution().numberOfWays(startPos, endPos, k));
    }
}