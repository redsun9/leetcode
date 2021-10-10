package leetcode.leetcode20xx.leetcode2035;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int minimumDifference(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.compute(num, (k, v) -> v == null ? 1 : v + 1);
        int[][] vals = new int[counts.size()][2];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            vals[pos][0] = entry.getKey();
            vals[pos][1] = entry.getValue();
            pos++;
        }
        return dfs(0, 0, nums.length, 0, vals.length, vals);
    }

    private static int dfs(int diffSum, int diff, int left, int i, int n, int[][] vals) {
        if (i == n - 1) return Math.abs(diffSum - diff * vals[i][0]);
        int tmp = Integer.MAX_VALUE;
        diffSum += vals[i][0] * vals[i][1];
        diff += vals[i][1];
        left -= vals[i][1];
        for (int j = 0; j <= vals[i][1]; j++, diff -= 2, diffSum -= 2 * vals[i][0]) {
            if (left >= Math.abs(diff)) tmp = Math.min(tmp, dfs(diffSum, diff, left, i + 1, n, vals));
        }
        return tmp;
    }
}
