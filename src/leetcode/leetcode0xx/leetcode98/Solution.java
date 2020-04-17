package leetcode.leetcode0xx.leetcode98;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long l, long r) {
        return root == null ||
                root.val >= l && root.val <= r
                        && isValidBST(root.left, l, root.val - 1L)
                        && isValidBST(root.right, root.val + 1L, r);
    }
}
