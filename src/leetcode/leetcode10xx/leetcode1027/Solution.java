package leetcode.leetcode10xx.leetcode1027;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 2;
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            Map<Integer, Integer> map = dp[i];
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                int len = dp[j].getOrDefault(d, 1) + 1;
                map.put(d, len);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
