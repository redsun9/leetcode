package leetcode.leetcode18xx.leetcode1894;

import java.util.Arrays;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) return 0;
        for (int i = 1; i < n; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) return i;
        }
        k %= chalk[n - 1];
        int ans = Arrays.binarySearch(chalk, k);
        if (ans < 0) ans = -ans - 1;
        else ans++;
        return ans;
    }
}
