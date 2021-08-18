package leetcode.leetcode6xx.leetcode698;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    @Test
    void canPartitionKSubsets() {
        int[] nums = {2, 3, 3, 2, 2};
        int k = 3;
        assertFalse(new Solution().canPartitionKSubsets(nums, k));
    }
}