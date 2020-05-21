package leetcode.leetcode13xx.leetcode1379;

import leetcode.tools.TreeNode;

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
