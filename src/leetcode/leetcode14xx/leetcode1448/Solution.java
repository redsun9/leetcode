package leetcode.leetcode14xx.leetcode1448;

import leetcode.tools.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private static int goodNodes(TreeNode root, int val) {
        if (root == null) return 0;
        if (root.val >= val) return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        else return goodNodes(root.left, val) + goodNodes(root.right, val);
    }
}
