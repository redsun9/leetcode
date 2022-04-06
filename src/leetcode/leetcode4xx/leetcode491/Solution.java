package leetcode.leetcode4xx.leetcode491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        dfs(0, 0, n, new int[n], nums, ans);
        return ans;
    }

    private static void dfs(
            int tmpPos, int numPos, int n,
            int[] tmp, int[] nums,
            List<List<Integer>> ans
    ) {
        if (tmpPos >= 2) {
            List<Integer> list = new ArrayList<>(tmpPos);
            for (int i = 0; i < tmpPos; i++) list.add(tmp[i]);
            ans.add(list);
        }
        Set<Integer> used = new HashSet<>();
        for (int i = numPos; i < n; i++) {
            if (used.contains(nums[i])) continue;
            if (tmpPos == 0 || nums[i] >= tmp[tmpPos - 1]) {
                used.add(nums[i]);
                tmp[tmpPos] = nums[i];
                dfs(tmpPos + 1, i + 1, n, tmp, nums, ans);
            }
        }
    }
}
