package leetcode.leetcode0xx.leetcode40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        LinkedList<List<Integer>> ans = new LinkedList<>();
        boolean[] used = new boolean[n + 1];
        used[0] = true;
        combinationSum(candidates, target, 0, n, used, ans);
        return ans;
    }

    private static void combinationSum(int[] candidates, int target, int index, int n, boolean[] used, List<List<Integer>> ans) {
        if (target == 0) {
            addSubAns(candidates, used, index, ans);
            return;
        }
        if (index >= n || candidates[index] > target) return;
        combinationSum(candidates, target, index + 1, n, used, ans);
        if (used[index] || candidates[index - 1] != candidates[index]) {
            used[index + 1] = true;
            combinationSum(candidates, target - candidates[index], index + 1, n, used, ans);
            used[index + 1] = false;
        }
    }

    private static void addSubAns(int[] candidates, boolean[] used, int n, List<List<Integer>> ans) {
        LinkedList<Integer> subAns = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (used[i + 1]) subAns.add(candidates[i]);
        }
        ans.add(subAns);
    }
}
