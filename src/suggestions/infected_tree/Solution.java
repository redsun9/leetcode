package suggestions.infected_tree;

import leetcode.tools.TreeNode;

import static java.lang.Math.max;

public class Solution {
    public static int recursiveSolution(TreeNode root) {
        return dfs(root)[1];
    }

    //size,dp
    private static int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{l[0] + r[0] + 1, max(0, max(l[0] - 1 + r[1], r[0] - 1 + l[1]))};
    }
}
