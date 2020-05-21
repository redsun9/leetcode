package leetcode.leetcode9xx.leetcode951;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean flipEquiv(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null ^ b == null) return false;
        return a.val == b.val && (
                flipEquiv(a.left, b.left) && flipEquiv(a.right, b.right)
                        || flipEquiv(a.left, b.right) && flipEquiv(a.right, b.left)
        );
    }
}
