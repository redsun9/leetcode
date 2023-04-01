package leetcode.leetcode25xx.leetcode2554;

import java.util.Arrays;

public class Solution2 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int ans = 0, prev = 0;
        for (int curr : banned) {
            if (maxSum <= prev) return ans;
            if (curr > n) curr = n + 1;
            if (curr > prev + 1) {
                long tmp = sumArithmeticSequence(prev + 1, curr - 1);
                if (tmp <= maxSum) {
                    ans += curr - prev - 1;
                    maxSum -= tmp;
                } else {
                    int x = maxArithmeticSequence(prev + 1, maxSum);
                    x = Math.min(x, n);
                    ans += x - prev;
                    return ans;
                }
            }
            prev = curr;
        }
        if (prev < n) {
            long tmp = sumArithmeticSequence(prev + 1, n);
            if (tmp <= maxSum) {
                ans += n - prev;
            } else {
                int x = maxArithmeticSequence(prev + 1, maxSum);
                x = Math.min(x, n);
                ans += x - prev;
            }
        }
        return ans;
    }

    private static int maxArithmeticSequence(int start, int maxSum) {
        long end = Math.round((Math.sqrt(4L * start * start - 4L * start + 8L * maxSum + 1) - 1) / 2);
        if ((end - start + 1L) * (start + end) / 2 > maxSum) end--;
        return (int) end;
    }

    private static long sumArithmeticSequence(int start, int end) {
        return (end - start + 1L) * (start + end) / 2;
    }
}
