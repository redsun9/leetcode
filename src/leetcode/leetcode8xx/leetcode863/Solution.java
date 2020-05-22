package leetcode.leetcode8xx.leetcode863;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static final int MAX_NODES = 501;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        return distanceK(root, target.val, k);
    }

    public List<Integer> distanceK(TreeNode root, int target, int k) {
        boolean[] path = new boolean[MAX_NODES];
        int depth = path(root, target, path, 0);
        TreeNode tmp = root;
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            if (depth - i == k) ans.add(tmp.val);
            if (depth - i < k) {
                if (path[i]) addWithDist(tmp.left, k - depth + i - 1, ans);
                else addWithDist(tmp.right, k - depth + i - 1, ans);
            }
            if (path[i]) tmp = tmp.right;
            else tmp = tmp.left;
        }
        addWithDist(tmp, k, ans);
        return ans;
    }


    private static void addWithDist(TreeNode root, int k, List<Integer> ans) {
        if (root == null) return;
        if (k == 0) {
            ans.add(root.val);
        } else {
            addWithDist(root.left, k - 1, ans);
            addWithDist(root.right, k - 1, ans);
        }
    }

    private static int path(TreeNode root, int target, boolean[] path, int depth) {
        if (root != null) {
            if (root.val == target) {
                return depth;
            }
            if (root.left != null) {
                path[depth] = false;
                int res = path(root.left, target, path, depth + 1);
                if (res >= 0) return res;
            }
            if (root.right != null) {
                path[depth] = true;
                int res = path(root.right, target, path, depth + 1);
                if (res >= 0) return res;
            }
        }
        return -1;
    }
}
