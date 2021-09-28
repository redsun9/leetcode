package leetcode.leetcode2xx.leetcode259;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        assertEquals(2, new Solution().threeSumSmaller(nums, target));
    }

    @Test
    void test2() {
        int[] nums = {-2, 0, -1, 3};
        int target = 2;
        assertEquals(3, new Solution().threeSumSmaller(nums, target));
    }

    @Test
    void test3() {
        int[] nums = {2, 0, 0, 2, -2};
        int target = 2;
        assertEquals(5, new Solution().threeSumSmaller(nums, target));
    }
}