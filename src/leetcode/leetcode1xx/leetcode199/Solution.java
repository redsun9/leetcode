package leetcode.leetcode1xx.leetcode199;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        deepest(root, -1, 0, ans);
        return ans;
    }

    private static int deepest(TreeNode root, int prevMaxDepth, int curDepth, List<Integer> ans) {
        if (root == null) return prevMaxDepth;
        if (curDepth > prevMaxDepth) ans.add(root.val);
        prevMaxDepth = deepest(root.right, prevMaxDepth, curDepth + 1, ans);
        prevMaxDepth = deepest(root.left, prevMaxDepth, curDepth + 1, ans);
        return Math.max(prevMaxDepth, curDepth);
    }
}
