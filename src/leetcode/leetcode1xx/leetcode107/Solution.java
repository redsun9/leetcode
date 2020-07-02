package leetcode.leetcode1xx.leetcode107;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderBottom(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private static void levelOrderBottom(TreeNode root, int curLevel, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() <= curLevel) ans.add(new LinkedList<>());
        ans.get(curLevel).add(root.val);
        levelOrderBottom(root.left, curLevel + 1, ans);
        levelOrderBottom(root.right, curLevel + 1, ans);
    }
}
