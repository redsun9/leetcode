package leetcode.leetcode6xx.leetcode617;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        return new TreeNode(
                t1.val + t2.val,
                mergeTrees(t1.left, t2.left),
                mergeTrees(t1.right, t2.right)
        );
    }
}
