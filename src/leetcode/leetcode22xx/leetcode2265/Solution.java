package leetcode.leetcode22xx.leetcode2265;

import leetcode.tools.TreeNode;

public class Solution {
    public int averageOfSubtree(TreeNode root) {
        return dfs(root).ans;
    }

    private static Result dfs(TreeNode root) {
        if (root == null) return new Result(0, 0, 0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        int ans = right.ans + left.ans;
        if (sum / count == root.val) ans++;
        return new Result(ans, sum, count);
    }

    private record Result(int ans, int sum, int count) {
    }
}
