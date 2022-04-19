package leetcode.leetcode0xx.leetcode99;

import leetcode.tools.TreeNode;

public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] badNodes = new TreeNode[3];
        traverse(root, badNodes);
        int tmp = badNodes[0].val;
        badNodes[0].val = badNodes[1].val;
        badNodes[1].val = tmp;
    }

    private static void traverse(TreeNode root, TreeNode[] nodes) {
        if (root == null) return;
        traverse(root.left, nodes);
        if (nodes[0] == null && nodes[2] != null && nodes[2].val >= root.val) nodes[0] = nodes[2];
        if (nodes[0] != null && nodes[2].val >= root.val) nodes[1] = root;
        nodes[2] = root;
        traverse(root.right, nodes);
    }
}
