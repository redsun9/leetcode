package leetcode.leetcode13xx.leetcode1372;

import leetcode.tools.TreeNode;

public class Solution {
    public int longestZigZag(TreeNode root) {
        return dfs(root).max;
    }

    private static Triple dfs(TreeNode root) {
        if (root.left == null && root.right == null) return new Triple(0, 0, 0);
        else if (root.left == null) {
            Triple right = dfs(root.right);
            return new Triple(max(right.max, right.left + 1), 0, right.left + 1);
        } else if (root.right == null) {
            Triple left = dfs(root.left);
            return new Triple(max(left.max, left.right + 1), left.right + 1, 0);
        } else {
            Triple right = dfs(root.right);
            Triple left = dfs(root.left);
            return new Triple(
                    max(right.left + 1, left.right + 1, right.max, left.max),
                    left.right + 1,
                    right.left + 1
            );
        }
    }


    private static int max(int... arr) {
        int max = arr[0];
        for (int a : arr) max = Math.max(max, a);
        return max;
    }


    private static class Triple {
        final int max, left, right;

        public Triple(int max, int left, int right) {
            this.max = max;
            this.left = left;
            this.right = right;
        }
    }
}
