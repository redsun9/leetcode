package leetcode.leetcode0xx.leetcode39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int[] tmp = new int[n];
        combinationSum(candidates, target, 0, n, tmp, ans);
        return ans;
    }

    private static void combinationSum(int[] candidates, int target, int index, int n, int[] tmp, List<List<Integer>> ans) {
        if (candidates[index] > target) return;
        if (index == n - 1) {
            if (target % candidates[index] == 0) {
                tmp[index] = target / candidates[index];
                addSubAns(candidates, tmp, index, ans);
            }
        } else {
            int max = target / candidates[index];
            if (max * candidates[index] == target) {
                tmp[index] = max;
                addSubAns(candidates, tmp, index, ans);
                max--;
            }
            for (int i = 0; i <= max; i++) {
                tmp[index] = i;
                combinationSum(candidates, target - i * candidates[index], index + 1, n, tmp, ans);
            }
        }
    }

    private static void addSubAns(int[] candidates, int[] tmp, int n, List<List<Integer>> ans) {
        LinkedList<Integer> subAns = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = tmp[i]; j > 0; j--) {
                subAns.add(candidates[i]);
            }
        }
        ans.add(subAns);
    }
}
