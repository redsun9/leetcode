package leetcode.leetcode13xx.leetcode1373;

import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static leetcode.tools.LeetcodeUtils.initializeTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ConstantConditions")
class SolutionTest {

    @Test
    void test1() {
        TreeNode root = initializeTree(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6});
        Solution solution = new Solution();
        assertEquals(20, solution.maxSumBST(root));
    }

    @Test
    void test2() {
        TreeNode root = initializeTree(new Integer[]{4, 3, null, 1, 2});
        Solution solution = new Solution();
        assertEquals(2, solution.maxSumBST(root));
    }

    @Test
    void test3() {
        TreeNode root = initializeTree(new Integer[]{-4, -2, -5});
        Solution solution = new Solution();
        assertEquals(0, solution.maxSumBST(root));
    }

    @Test
    void test4() {
        TreeNode root = initializeTree(new Integer[]{2, 1, 3});
        Solution solution = new Solution();
        assertEquals(6, solution.maxSumBST(root));
    }

    @Test
    void test5() {
        TreeNode root = initializeTree(new Integer[]{5, 4, 8, 3, null, 6, 3});
        Solution solution = new Solution();
        assertEquals(7, solution.maxSumBST(root));
    }
}