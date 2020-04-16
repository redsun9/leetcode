package leetcode.leetcode9xx.leetcode968;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        TreeNode root = LeetcodeUtils.initializeTree(new Integer[]{1, 2, null, 3, null, 4, null, null, 5});
        Solution solution = new Solution();
        assertEquals(2, solution.minCameraCover(root));
    }
}