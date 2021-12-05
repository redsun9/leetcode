package leetcode.leetcode20xx.leetcode2096;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        Integer[] arr = {5, 1, 2, 3, null, 6, 4};
        TreeNode root = LeetcodeUtils.initializeTree(arr);
        assertEquals("UURL", new Solution().getDirections(root, 3, 6));
    }

    @Test
    void test2() {
        Integer[] arr = {2, 1};
        TreeNode root = LeetcodeUtils.initializeTree(arr);
        assertEquals("L", new Solution().getDirections(root, 2, 1));
    }
}