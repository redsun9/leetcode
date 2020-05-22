package leetcode.leetcode8xx.leetcode872;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Integer[] arr1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] arr2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
        TreeNode root1 = LeetcodeUtils.initializeTree(arr1);
        TreeNode root2 = LeetcodeUtils.initializeTree(arr2);
        assertTrue(new Solution2().leafSimilar(root1, root2));
    }
}