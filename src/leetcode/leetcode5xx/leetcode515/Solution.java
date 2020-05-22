package leetcode.leetcode5xx.leetcode515;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private static void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root != null) {
            if (ans.size() == depth) ans.add(root.val);
            else ans.set(depth, Math.max(ans.get(depth), root.val));
            dfs(root.left, depth + 1, ans);
            dfs(root.right, depth + 1, ans);
        }
    }
}
