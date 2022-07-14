package leetcode.leetcode1xx.leetcode105;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        Integer[] expected = {3, 9, 20, null, null, 15, 7};
        TreeNode expectedTree = LeetcodeUtils.initializeTree(expected);
        assertEquals(expectedTree, new Solution().buildTree(preorder, inorder));
    }

    @Test
    void test2() {
        int[] preorder = {-1}, inorder = {-1};
        Integer[] expected = {-1};
        TreeNode expectedTree = LeetcodeUtils.initializeTree(expected);
        assertEquals(expectedTree, new Solution().buildTree(preorder, inorder));
    }
}