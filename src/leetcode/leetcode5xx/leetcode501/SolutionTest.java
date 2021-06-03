package leetcode.leetcode5xx.leetcode501;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        Integer[] root = {1, null, 2, 2};
        TreeNode tree = LeetcodeUtils.initializeTree(root);
        assertArrayEquals(new int[]{2}, new Solution().findMode(tree));
    }

    @Test
    void test2() {
        Integer[] root = {0};
        TreeNode tree = LeetcodeUtils.initializeTree(root);
        assertArrayEquals(new int[]{0}, new Solution().findMode(tree));
    }
}