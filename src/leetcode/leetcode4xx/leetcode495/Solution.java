package leetcode.leetcode4xx.leetcode495;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;
        int i = 0, ans = 0;
        while (i < n) {
            int start = timeSeries[i], end = start;
            while (i < n && timeSeries[i] <= end) end = timeSeries[i++] + duration;
            ans += end - start;
        }
        return ans;
    }
}
