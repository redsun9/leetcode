package leetcode.leetcode20xx.leetcode2096;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> path1 = new ArrayList<>();
        List<Character> path2 = new ArrayList<>();
        dfs(root, startValue, path1);
        dfs(root, destValue, path2);

        int l1 = path1.size(), l2 = path2.size(), common = 0;
        while (common < l1 && common < l2 && path1.get(common) == path2.get(common)) common++;

        char[] ans = new char[l1 - common + l2 - common];
        Arrays.fill(ans, 0, l1 - common, 'U');
        for (int i = l1 - common; common < l2; i++, common++) ans[i] = path2.get(common);
        return new String(ans);
    }

    private static boolean dfs(TreeNode root, int value, List<Character> path) {
        if (root.val == value) return true;
        if (root.left != null) {
            path.add('L');
            if (dfs(root.left, value, path)) return true;
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add('R');
            if (dfs(root.right, value, path)) return true;
            path.remove(path.size() - 1);
        }
        return false;
    }
}
