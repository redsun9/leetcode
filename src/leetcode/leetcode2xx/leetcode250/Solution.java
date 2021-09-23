package leetcode.leetcode2xx.leetcode250;

import leetcode.tools.TreeNode;

@SuppressWarnings("SpellCheckingInspection")
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        return root == null ? 0 : dfs(root).numOfUnival;
    }

    private static Result dfs(TreeNode root) {
        if (root.left == null && root.right == null) return Result.leaf;
        Result left = root.left != null ? dfs(root.left) : null;
        Result right = root.right != null ? dfs(root.right) : null;

        int numOfUnival = (left != null ? left.numOfUnival : 0) + (right != null ? right.numOfUnival : 0);
        boolean allSame = (left == null || left.allSame && root.val == root.left.val) &&
                (right == null || right.allSame && root.val == root.right.val);
        if (allSame) numOfUnival++;
        return new Result(allSame, numOfUnival);
    }

    private static final class Result {
        int numOfUnival;
        boolean allSame;

        static Result leaf = new Result(true, 1);

        public Result(boolean allSame, int numOfUnival) {
            this.allSame = allSame;
            this.numOfUnival = numOfUnival;
        }
    }
}
