package leetcode.leetcode6xx.leetcode658;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findClosestElements() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(Arrays.asList(1, 2, 3, 4), new Solution().findClosestElements(nums, 4, 3));
    }
}