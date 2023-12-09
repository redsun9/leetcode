package leetcode.leetcode25xx.leetcode2569;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void handleQuery() {
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {0, 0, 0};
        int[][] queries = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        long[] expected = {3L};
        long[] actual = new Solution().handleQuery(nums1, nums2, queries);
        assertArrayEquals(expected, actual);
    }
}