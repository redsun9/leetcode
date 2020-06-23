package leetcode.leetcode2xx.leetcode222;

import leetcode.tools.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lo = 1;
        TreeNode tmp = root;
        int h = 0;
        while (tmp.left != null) {
            lo <<= 1;
            tmp = tmp.left;
            h++;
        }
        int hi = lo * 2 - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (exists(root, mid, h)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean exists(TreeNode root, int check, int h) {
        if (root == null) return false;
        if (h == 0) return true;
        h--;
        return ((check >> h) & 1) == 0 ? exists(root.left, check, h) : exists(root.right, check, h);
    }
}
