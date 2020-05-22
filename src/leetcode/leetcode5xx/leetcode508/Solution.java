package leetcode.leetcode5xx.leetcode508;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, new HashMap<>());
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        int sum = root.val + left.sum + right.sum;
        right.map.forEach((key, value) -> left.map.merge(key, value, Integer::sum));
        left.map.merge(sum, 1, Integer::sum);
        return new Pair(sum, left.map);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = dfs(root).map;
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
            else if (entry.getValue() > max) {
                max = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }

    private static class Pair {
        int sum;
        HashMap<Integer, Integer> map;

        public Pair(int sum, HashMap<Integer, Integer> map) {
            this.sum = sum;
            this.map = map;
        }
    }
}
