package leetcode.leetcode2xx.leetcode270;

import leetcode.tools.TreeNode;

public class Solution2 {
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) return root.val;
        if (root.val < target) return closestValue(root.right, target, root.val);
        else return closestValue(root.left, target, root.val);
    }

    private static int closestValue(TreeNode root, double target, int currentClosest) {
        if (root == null) return currentClosest;
        if (root.val == target) return root.val;
        if (Math.abs(root.val - target) < Math.abs(currentClosest - target)) currentClosest = root.val;
        if (root.val < target) return closestValue(root.right, target, currentClosest);
        else return closestValue(root.left, target, currentClosest);
    }
}
