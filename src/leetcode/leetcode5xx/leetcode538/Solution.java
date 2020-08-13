package leetcode.leetcode5xx.leetcode538;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private static int dfs(TreeNode root, int sum) {
        if (root == null) return sum;
        if (root.right != null) {
            sum = dfs(root.right, sum);
        }
        root.val += sum;
        return dfs(root.left, root.val);
    }
}
