package leetcode.leetcode1xx.leetcode164;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) return 0;
        if (min + 1 == max) return 1;

        int nBuckets = n - 1;
        long gap = ((long) max - min + n - 2) / nBuckets;
        int[][] buckets = new int[2][nBuckets];

        Arrays.fill(buckets[0], Integer.MAX_VALUE);
        Arrays.fill(buckets[1], Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int bucket = (int) (((long) num - min) / gap);
            buckets[0][bucket] = Math.min(buckets[0][bucket], num);
            buckets[1][bucket] = Math.max(buckets[1][bucket], num);
        }

        int ans = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < nBuckets; i++) {
            if (buckets[0][i] == Integer.MAX_VALUE && buckets[1][i] == Integer.MIN_VALUE) continue;
            ans = Math.max(ans, buckets[0][i] - prev);
            prev = buckets[1][i];
        }
        ans = Math.max(ans, max - prev);
        return ans;
    }
}
