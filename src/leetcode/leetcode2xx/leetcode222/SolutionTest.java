package leetcode.leetcode2xx.leetcode222;

import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        for (int n = 0; n < 1000; n++) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            TreeNode root = LeetcodeUtils.initializeTree(arr);
            assertEquals(n, new Solution().countNodes(root));
        }
    }
}