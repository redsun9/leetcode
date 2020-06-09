package leetcode.leetcode6xx.leetcode679;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        // 6/(1-3/4)
        assertTrue(new Solution().judgePoint24(new int[]{1, 3, 4, 6}));
    }
}