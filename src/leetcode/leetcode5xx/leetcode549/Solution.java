package leetcode.leetcode5xx.leetcode549;

import leetcode.tools.TreeNode;

public class Solution {
    public int longestConsecutive2(TreeNode root) {
        if (root == null) return 0;
        return dfs(root)[0];
    }

    // max, maxInc, maxDec
    private static int[] dfs(TreeNode root) {
        int[] ans = {1, 1, 1};
        if (root.left != null) {
            int[] left = dfs(root.left);
            ans[0] = Math.max(ans[0], left[0]);
            if (root.left.val == root.val - 1) ans[2] = Math.max(ans[2], left[2] + 1);
            if (root.left.val == root.val + 1) ans[1] = Math.max(ans[1], left[1] + 1);
        }

        if (root.right != null) {
            int[] right = dfs(root.right);
            ans[0] = Math.max(ans[0], right[0]);
            if (root.right.val == root.val - 1) ans[2] = Math.max(ans[2], right[2] + 1);
            if (root.right.val == root.val + 1) ans[1] = Math.max(ans[1], right[1] + 1);
        }
        ans[0] = Math.max(ans[0], ans[1] + ans[2] - 1);
        return ans;
    }
}
