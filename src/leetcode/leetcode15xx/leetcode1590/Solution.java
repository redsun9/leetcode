package leetcode.leetcode15xx.leetcode1590;

import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) sum += num;
        long m = sum % p;
        if (m == 0) return 0;
        m = p - m;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        sum = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans = Math.min(ans, i - map.getOrDefault((sum + m) % p, -n));
            map.put(sum % p, i);
        }
        return ans == n ? -1 : ans;
    }
}
