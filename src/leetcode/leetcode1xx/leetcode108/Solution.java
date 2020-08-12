package leetcode.leetcode1xx.leetcode108;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        return dfs(nums, 0, n);
    }

    private static TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo >= hi) return null;
        int mid = (lo + hi) / 2;
        return new TreeNode(nums[mid], dfs(nums, lo, mid), dfs(nums, mid + 1, hi));
    }
}
