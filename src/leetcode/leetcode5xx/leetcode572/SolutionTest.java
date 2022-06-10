package leetcode.leetcode5xx.leetcode572;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Integer[] root = {3, 4, 5, 1, 2}, subRoot = {4, 1, 2};
        TreeNode tree = LeetcodeUtils.initializeTree(root);
        TreeNode subTree = LeetcodeUtils.initializeTree(subRoot);
        assertTrue(new Solution().isSubtree(tree, subTree));
        assertTrue(new Solution2().isSubtree(tree, subTree));
        assertTrue(new Solution3().isSubtree(tree, subTree));
    }

    @Test
    void test2() {
        Integer[] root = {3, 4, 5, 1, 2, null, null, null, null, 0}, subRoot = {4, 1, 2};
        TreeNode tree = LeetcodeUtils.initializeTree(root);
        TreeNode subTree = LeetcodeUtils.initializeTree(subRoot);
        assertFalse(new Solution().isSubtree(tree, subTree));
        assertFalse(new Solution2().isSubtree(tree, subTree));
        assertFalse(new Solution3().isSubtree(tree, subTree));
    }
}