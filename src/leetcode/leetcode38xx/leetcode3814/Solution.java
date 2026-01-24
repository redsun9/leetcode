package leetcode.leetcode38xx.leetcode3814;

import java.util.Arrays;

public class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = costs[i];
            arr[i][1] = capacity[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = Math.max(prefix[i], arr[i][1]);

        int ans = 0;
        for (int l = 0, r = n - 1; r >= 0; r--) {
            if (arr[r][0] >= budget) continue;
            while (l < r && arr[l][0] + arr[r][0] < budget) l++;
            ans = Math.max(ans, prefix[Math.min(l, r)] + arr[r][1]);
        }
        return ans;
    }
}
