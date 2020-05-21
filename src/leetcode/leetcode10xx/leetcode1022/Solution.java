package leetcode.leetcode10xx.leetcode1022;

import leetcode.tools.TreeNode;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private static int sum(TreeNode root, int prev) {
        prev = (prev << 1) + root.val;
        if (root.right == null && root.left == null) return prev;
        int sum = 0;
        if (root.left != null) sum += sum(root.left, prev);
        if (root.right != null) sum += sum(root.right, prev);
        return sum;
    }
}
