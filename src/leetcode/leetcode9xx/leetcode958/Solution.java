package leetcode.leetcode9xx.leetcode958;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root, 0, countNodes(root));
    }

    private static boolean isCompleteTree(TreeNode root, int i, int n) {
        if (root == null) return true;
        else if (i >= n) return false;
        return isCompleteTree(root.left, 2 * i + 1, n) && isCompleteTree(root.right, 2 * i + 2, n);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
