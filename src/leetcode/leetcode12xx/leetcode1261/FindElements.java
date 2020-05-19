package leetcode.leetcode12xx.leetcode1261;

import leetcode.tools.TreeNode;

public class FindElements {
    private final TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        correct(root, 0);
    }

    public boolean find(int target) {
        if (target < 0) return false;
        if (target == 0) return true;
        return find(root, target + 1, Integer.highestOneBit(target + 1));
    }

    private static boolean find(TreeNode root, int target, int tmp) {
        if (root == null || tmp == 0) return false;
        if (root.val == target - 1) return true;
        tmp >>>= 1;
        if ((target & tmp) == 0) return find(root.left, target, tmp);
        else return find(root.right, target, tmp);
    }

    private static void correct(TreeNode root, int val) {
        if (root != null) {
            root.val = val;
            correct(root.left, val * 2 + 1);
            correct(root.right, val * 2 + 2);
        }
    }
}
