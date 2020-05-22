package leetcode.leetcode4xx.leetcode437;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return dfs(root, sum, 0, preSum);
    }

    private static int dfs(TreeNode root, int target, int currSum, Map<Integer, Integer> preSum) {
        if (root == null) return 0;
        currSum += root.val;
        int ans = preSum.getOrDefault(currSum - target, 0);
        preSum.merge(currSum, 1, Integer::sum);
        ans += dfs(root.left, target, currSum, preSum);
        ans += dfs(root.right, target, currSum, preSum);
        preSum.compute(currSum, (key, value) -> value - 1);
        return ans;
    }
}
