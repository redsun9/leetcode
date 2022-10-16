package leetcode.leetcode24xx.leetcode2439;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {4, 7, 2, 2, 9, 19, 16, 0, 3, 15};
        assertEquals(9, new Solution().minimizeArrayValue(nums));
    }
}