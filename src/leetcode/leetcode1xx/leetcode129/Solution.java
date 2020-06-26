package leetcode.leetcode1xx.leetcode129;

import leetcode.tools.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int cur) {
        if (root == null) return 0;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) return cur;
        else return sumNumbers(root.left, cur) + sumNumbers(root.right, cur);
    }
}
