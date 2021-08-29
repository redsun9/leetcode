package leetcode.leetcode19xx.leetcode1985;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        assertEquals("3", new Solution().kthLargestNumber(nums, k));
    }

    @Test
    void test2() {
        String[] nums = {"2", "21", "12", "1"};
        int k = 3;
        assertEquals("2", new Solution().kthLargestNumber(nums, k));
    }

    @Test
    void test3() {
        String[] nums = {"0", "0"};
        int k = 2;
        assertEquals("0", new Solution().kthLargestNumber(nums, k));
    }
}