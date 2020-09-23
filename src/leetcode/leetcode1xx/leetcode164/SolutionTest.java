package leetcode.leetcode1xx.leetcode164;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 6, 9, 1};
        assertEquals(3, new Solution().maximumGap(nums));
    }
}