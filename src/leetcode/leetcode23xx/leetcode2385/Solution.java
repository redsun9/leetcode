package leetcode.leetcode23xx.leetcode2385;

import leetcode.tools.TreeNode;

@SuppressWarnings("DuplicateExpressions")
public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        return dfs(root, start).ans;
    }

    private static Result dfs(TreeNode root, int start) {
        Result left = root.left == null ? Result.empty : dfs(root.left, start);
        Result right = root.right == null ? Result.empty : dfs(root.right, start);
        if (root.val == start) return new Result(true, 1 + Math.max(left.h, right.h), 0);
        if (!left.infected && !right.infected) return new Result(false, -1, 1 + Math.max(left.h, right.h));
        if (left.infected) return new Result(true, Math.max(left.ans, left.h + 2 + right.h), left.h + 1);
        return new Result(true, Math.max(right.ans, right.h + 2 + left.h), right.h + 1);
    }


    private record Result(boolean infected, int ans, int h) {
        private static final Result empty = new Result(false, -1, -1);
    }
}
