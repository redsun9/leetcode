package leetcode.leetcode5xx.leetcode572;

import leetcode.tools.TreeNode;

public class Solution2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isEqual(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }
}
