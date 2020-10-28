package leetcode.leetcode1xx.leetcode114;

import leetcode.tools.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode last = root.left;
                while (last.right != null) last = last.right;
                last.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
