package leetcode.leetcode9xx.leetcode938;

import leetcode.tools.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int l, int r) {
        return rangeSumBST(root, l, r, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int rangeSumBST(TreeNode root, int ql, int qr, int l, int r) {
        int ans = 0;
        if (root.val >= ql && root.val <= qr) ans += root.val;
        if (root.left != null && ql < root.val && l <= qr) ans += rangeSumBST(root.left, ql, qr, l, root.val - 1);
        if (root.right != null && qr > root.val && r >= ql) ans += rangeSumBST(root.right, ql, qr, root.val + 1, r);
        return ans;
    }
}
