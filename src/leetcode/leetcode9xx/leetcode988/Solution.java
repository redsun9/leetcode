package leetcode.leetcode9xx.leetcode988;

import leetcode.tools.TreeNode;

import java.util.Arrays;

public class Solution {
    private static final int maxLength = 8500;

    public String smallestFromLeaf(TreeNode root) {
        int[] ans = new int[maxLength];
        Arrays.fill(ans, 25);
        Result result = new Result(ans, maxLength);
        int[] tmp = new int[maxLength];
        dfs(root, 0, result, tmp);
        StringBuilder sb = new StringBuilder(result.length);
        for (int i = result.length - 1; i >= 0; i--) {
            sb.append((char) (ans[i] + 'a'));
        }
        return sb.toString();
    }

    private static void dfs(TreeNode root, int depth, Result result, int[] tmp) {
        tmp[depth++] = root.val;
        if (root.left == null && root.right == null) update(result, tmp, depth);
        if (root.left != null) dfs(root.left, depth, result, tmp);
        if (root.right != null) dfs(root.right, depth, result, tmp);
    }

    private static void update(Result result, int[] tmp, int depth) {
        boolean less = false;
        int i = result.length - 1;
        int j = depth - 1;
        int[] prev = result.ans;
        while (i >= 0 && j >= 0) {
            if (prev[i] != tmp[j]) {
                less = prev[i] > tmp[j];
                break;
            }
            i--;
            j--;
        }
        if (i < 0 || j < 0) less = j < 0 && i >= 0;
        if (less) {
            System.arraycopy(tmp, 0, prev, 0, depth);
            result.length = depth;
        }
    }


    private static class Result {
        int[] ans;
        int length;

        public Result(int[] ans, int length) {
            this.ans = ans;
            this.length = length;
        }
    }

}
