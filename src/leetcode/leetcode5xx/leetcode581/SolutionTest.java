package leetcode.leetcode5xx.leetcode581;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        assertEquals(5, solution.findUnsortedSubarray(nums));
        assertEquals(5, solution2.findUnsortedSubarray(nums));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 4, 3, 2, 5};
        assertEquals(3, solution.findUnsortedSubarray(nums));
        assertEquals(3, solution2.findUnsortedSubarray(nums));
    }

}