package leetcode.tools;

import org.junit.jupiter.api.Test;

import static leetcode.tools.LeetcodeUtils.initializeTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ConstantConditions")
class MaxSumBstTest {

    @Test
    void maxSumBST() {
        TreeNode root = initializeTree(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6});
        MaxSumBST maxSumBST = new MaxSumBST();
        assertEquals(21, maxSumBST.maxSumBST(root));
    }
}