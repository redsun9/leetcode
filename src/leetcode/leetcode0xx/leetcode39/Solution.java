package leetcode.leetcode0xx.leetcode39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        int[] gcd = new int[n];
        gcd[n - 1] = candidates[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            gcd[i] = gcd(candidates[i], gcd[i + 1]);
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int[] tmp = new int[n];
        combinationSum(candidates, target, 0, n, tmp, gcd, ans);
        return ans;
    }

    private static void combinationSum(int[] candidates, int target, int index, int n, int[] tmp, int[] gcd, List<List<Integer>> ans) {
        if (candidates[index] > target || target % gcd[index] != 0) return;
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
                combinationSum(candidates, target - i * candidates[index], index + 1, n, tmp, gcd, ans);
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

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

}
