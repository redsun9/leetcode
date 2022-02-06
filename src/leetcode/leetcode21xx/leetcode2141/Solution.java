package leetcode.leetcode21xx.leetcode2141;

import java.util.Arrays;

public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;
        if (n > m) return 0;
        Arrays.sort(batteries);

        long ans = 0, sum = 0;
        for (int i = 0; i < m; i++) {
            if (i != 0 && i > m - n) {
                long tmpVal = sum / (n - m + i);
                if (tmpVal >= batteries[i - 1] && tmpVal <= batteries[i]) {
                    ans = Math.max(ans, tmpVal);
                }
            }
            sum += batteries[i];
            if (sum / batteries[i] + m - i > n) ans = Math.max(ans, batteries[i]);
            if (sum / n >= batteries[i]) ans = Math.max(ans, sum / n);
        }
        return ans;

    }
}
