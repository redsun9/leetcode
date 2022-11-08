package leetcode.leetcode24xx.leetcode2458;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        Integer[] nums = {1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        int[] queries = {4};
        int[] expected = {2};
        assertArrayEquals(expected, new Solution().treeQueries(root, queries));
    }

    @Test
    void test2() {
        Integer[] nums = {5, 8, 9, 2, 1, 3, 7, 4, 6};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        int[] queries = {3, 2, 4, 8};
        int[] expected = {3, 2, 3, 2};
        assertArrayEquals(expected, new Solution().treeQueries(root, queries));
    }
}