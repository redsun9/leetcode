package leetcode.leetcode13xx.leetcode1325;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (remove(root, target)) return null;
        return root;
    }

    private static boolean remove(TreeNode root, int target) {
        if (root == null) return true;
        if (remove(root.left, target)) root.left = null;
        if (remove(root.right, target)) root.right = null;
        return root.left == null && root.right == null && root.val == target;
    }
}
