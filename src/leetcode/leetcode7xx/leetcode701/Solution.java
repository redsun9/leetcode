package leetcode.leetcode7xx.leetcode701;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) return node;
        TreeNode tmp = root;
        while (true) {
            if (tmp.val > val) {
                if (tmp.left == null) {
                    tmp.left = node;
                    break;
                } else tmp = tmp.left;
            } else {
                if (tmp.right == null) {
                    tmp.right = node;
                    break;
                } else tmp = tmp.right;
            }
        }
        return root;
    }
}