package leetcode.leetcode19xx.leetcode1982;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int[] ans = new int[n];
        dfs(0, n, ans, sums);
        return ans;
    }

    private void dfs(int i, int n, int[] ans, int[] sums) {
        if (i == n) return;

        int last = sums[sums.length - 1];
        int secondLast = sums[sums.length - 2];

        int val = secondLast >= 0 ? last - secondLast : -secondLast;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : sums) map.compute(num, (k, v) -> v == null ? 1 : v + 1);

        int[] smaller = new int[sums.length / 2];
        int[] larger = new int[sums.length / 2];

        int index = 0;

        boolean positive = false;

        for (int num : sums) {
            if (map.containsKey(num)) {
                smaller[index] = num;
                larger[index++] = val + num;
                map.compute(num, (k, v) -> v == 1 ? null : v - 1);
                map.compute(val + num, (k, v) -> v == 1 ? null : v - 1);
                positive |= num == 0;
            }
        }

        ans[i] = positive ? val : -val;
        int[] nextArr = positive ? smaller : larger;
        dfs(i + 1, n, ans, nextArr);
    }
}
