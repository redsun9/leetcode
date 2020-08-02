package leetcode.leetcode15xx.leetcode1530;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Integer[] arr = {1, 2, 3, null, 4};
        TreeNode root = LeetcodeUtils.initializeTree(arr);
        assertEquals(1, new Solution().countPairs(root, 3));
    }
}