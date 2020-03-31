package leetcode.leetcode13xx.leetcode1340;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] indices = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(i -> arr[i]))
                .mapToInt(i -> i).toArray();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int index : indices) {
            int val = arr[index];
            int tmp = index - 1;
            int curMax = -1;
            while (tmp >= 0 && index - tmp <= d && arr[tmp] < val) {
                curMax = Math.max(curMax, dp[tmp]);
                tmp--;
            }
            tmp = index + 1;
            while (tmp < n && tmp - index <= d && arr[tmp] < val) {
                curMax = Math.max(curMax, dp[tmp]);
                tmp++;
            }
            dp[index] = curMax + 1;
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans + 1;
    }
}
