package leetcode.leetcode13xx.leetcode1315;

import leetcode.tools.TreeNode;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, 0, 0);
    }


    public int sumEvenGrandparent(TreeNode root, int p, int gp) {
        if (root == null) return 0;
        return (gp != 0 && (gp & 1) == 0 ? root.val : 0) +
                sumEvenGrandparent(root.left, root.val, p) +
                sumEvenGrandparent(root.right, root.val, p);
    }
}
