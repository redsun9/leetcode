package leetcode.leetcode0xx.leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n + 1];
        used[0] = true;
        List<List<Integer>> ans = new LinkedList<>();
        dfs(nums, 0, n, used, 0, ans);
        return ans;
    }

    private static void dfs(int[] nums, int i, int n, boolean[] used, int nUsed, List<List<Integer>> ans) {
        if (i == n) {
            List<Integer> subAns = new ArrayList<>(nUsed);
            for (int j = 0; j < n; j++) {
                if (used[j + 1]) subAns.add(nums[j]);
            }
            ans.add(subAns);
            return;
        }
        dfs(nums, i + 1, n, used, nUsed, ans);
        if (used[i] || nums[i - 1] != nums[i]) {
            used[i + 1] = true;
            dfs(nums, i + 1, n, used, nUsed + 1, ans);
            used[i + 1] = false;
        }
    }
}
