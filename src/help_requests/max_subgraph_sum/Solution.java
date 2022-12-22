package help_requests.max_subgraph_sum;

import leetcode.tools.TreeNode;

// find nonempty subgraph of binary tree with max sum and return its sum
public class Solution {
    private static final long[] valForNull = {Long.MIN_VALUE, Long.MIN_VALUE};

    //recursive solution
    public static long recursiveSolution(TreeNode root) {
        return dfs(root)[0];
    }

    private static long[] dfs(TreeNode root) {
        long[] left = root.left != null ? dfs(root.left) : valForNull;
        long[] right = root.right != null ? dfs(root.right) : valForNull;

        long maxWithCurrentNode = root.val;
        if (left[1] > 0) maxWithCurrentNode += left[1];
        if (right[1] > 0) maxWithCurrentNode += right[1];

        long maxFromChild = Math.max(left[0], right[0]);
        return new long[]{Math.max(maxFromChild, maxWithCurrentNode), maxWithCurrentNode};
    }
}
