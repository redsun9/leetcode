package leetcode.leetcode2xx.leetcode235;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val != p.val && root.val != q.val) {
            if ((root.val > p.val) ^ (root.val > q.val)) break;
            if (root.val > p.val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}
