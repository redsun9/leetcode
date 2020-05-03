package leetcode.challenge_2020.april30th;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return root != null && isValidSequence(root, arr, 0, arr.length);
    }

    private static boolean isValidSequence(TreeNode root, int[] arr, int i, int n) {
        return root.val == arr[i] && (
                i == n - 1 && root.left == null && root.right == null ||
                        i < n - 1 && root.left != null && isValidSequence(root.left, arr, i + 1, n) ||
                        i < n - 1 && root.right != null && isValidSequence(root.right, arr, i + 1, n)
        );
    }
}
