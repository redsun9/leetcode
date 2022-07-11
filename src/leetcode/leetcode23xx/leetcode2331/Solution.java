package leetcode.leetcode23xx.leetcode2331;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        return switch (root.val) {
            case 0 -> false;
            case 1 -> true;
            case 2 -> evaluateTree(root.left) || evaluateTree(root.right);
            case 3 -> evaluateTree(root.left) && evaluateTree(root.right);
            default -> throw new IllegalStateException("Unexpected value: " + root.val);
        };
    }
}
