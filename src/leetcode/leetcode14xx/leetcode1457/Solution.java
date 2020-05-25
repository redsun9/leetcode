package leetcode.leetcode14xx.leetcode1457;

import leetcode.tools.TreeNode;

public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int count) {
        count ^= 1 << root.val;
        if (root.left == null && root.right == null) return (count & (count - 1)) == 0 ? 1 : 0;
        int ans = 0;
        if (root.left != null) ans += dfs(root.left, count);
        if (root.right != null) ans += dfs(root.right, count);
        return ans;
    }
}
