package leetcode.leetcode3xx.leetcode366;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private static int dfs(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return -1;
        int height = Math.max(dfs(root.left, ans), dfs(root.right, ans)) + 1;
        if (height >= ans.size()) ans.add(new ArrayList<>());
        ans.get(height).add(root.val);
        return height;
    }
}
