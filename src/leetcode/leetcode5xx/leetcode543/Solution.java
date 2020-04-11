package leetcode.leetcode5xx.leetcode543;

import leetcode.tools.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        IntWrapper ans = new IntWrapper();
        maxDepth(root, ans);
        return ans.value - 1;
    }

    private static int maxDepth(TreeNode root, IntWrapper intWrapper) {
        int l = root.left != null ? maxDepth(root.left, intWrapper) : 0;
        int r = root.right != null ? maxDepth(root.right, intWrapper) : 0;
        intWrapper.value = Math.max(intWrapper.value, l + r + 1);
        return Math.max(l, r) + 1;
    }

    private static class IntWrapper {
        private int value;
    }
}
