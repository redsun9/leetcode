package leetcode.leetcode6xx.leetcode606;

import leetcode.tools.TreeNode;

public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2str(root, sb);
        return sb.toString();
    }

    private static void tree2str(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        sb.append('(');
        tree2str(root.left, sb);
        sb.append(')');
        if (root.right == null) return;
        sb.append('(');
        tree2str(root.right, sb);
        sb.append(')');
    }
}
