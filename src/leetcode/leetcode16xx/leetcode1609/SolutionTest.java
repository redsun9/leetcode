package leetcode.leetcode16xx.leetcode1609;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Integer[] nums = {1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertTrue(new Solution().isEvenOddTree(root));
    }

    @Test
    void test2() {
        Integer[] nums = {5, 4, 2, 3, 3, 7};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertFalse(new Solution().isEvenOddTree(root));
    }

    @Test
    void test3() {
        Integer[] nums = {5, 9, 1, 3, 5, 7};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertFalse(new Solution().isEvenOddTree(root));
    }

    @Test
    void test4() {
        Integer[] nums = {1};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertTrue(new Solution().isEvenOddTree(root));
    }

    @Test
    void test5() {
        Integer[] nums = {11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17};
        TreeNode root = LeetcodeUtils.initializeTree(nums);
        assertTrue(new Solution().isEvenOddTree(root));
    }
}