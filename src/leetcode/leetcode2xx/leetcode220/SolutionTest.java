package leetcode.leetcode2xx.leetcode220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(new Solution().containsNearbyAlmostDuplicate(nums, 3, 0));
        assertTrue(new Solution2().containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    @Test
    void test2() {
        int[] nums = {1, 0, 1, 1};
        assertTrue(new Solution().containsNearbyAlmostDuplicate(nums, 1, 2));
        assertTrue(new Solution2().containsNearbyAlmostDuplicate(nums, 1, 2));
    }

    @Test
    void test3() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        assertFalse(new Solution().containsNearbyAlmostDuplicate(nums, 2, 3));
        assertFalse(new Solution2().containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    @Test
    void test4() {
        int[] nums = {-1, 2147483647};
        assertFalse(new Solution().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
        assertFalse(new Solution2().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

    @Test
    void test5() {
        int[] nums = {2147483647, -2147483647};
        assertFalse(new Solution().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
        assertFalse(new Solution2().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

    @Test
    void test6() {
        int[] nums = {-2147483648, -2147483647};
        assertTrue(new Solution().containsNearbyAlmostDuplicate(nums, 3, 3));
        assertTrue(new Solution2().containsNearbyAlmostDuplicate(nums, 3, 3));
    }
}