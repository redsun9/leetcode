package leetcode.leetcode8xx.leetcode814;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (cut(root)) return root;
        else return null;
    }

    private static boolean cut(TreeNode root) {
        boolean hasOnes = root.val == 1;
        if (root.left != null) {
            if (cut(root.left)) hasOnes = true;
            else root.left = null;
        }
        if (root.right != null) {
            if (cut(root.right)) hasOnes = true;
            else root.right = null;
        }
        return hasOnes;
    }
}
