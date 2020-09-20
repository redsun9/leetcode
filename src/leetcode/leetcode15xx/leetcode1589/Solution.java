package leetcode.leetcode15xx.leetcode1589;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] count = new int[n];
        for (int[] request : requests) {
            count[request[0]]++;
            if (request[1] != n - 1) count[request[1] + 1]--;
        }
        for (int i = 1; i < n; i++) count[i] += count[i - 1];

        Arrays.sort(nums);
        Arrays.sort(count);

        long ans = 0;
        for (int i = 0; i < n; i++) ans += ((long) nums[i]) * count[i];
        return (int) (ans % p);
    }
}
