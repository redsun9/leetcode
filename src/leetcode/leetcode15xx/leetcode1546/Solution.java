package leetcode.leetcode15xx.leetcode1546;

import java.util.HashMap;

public class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = 0, sum = 0, last = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.getOrDefault(sum - target, -2) >= last) {
                ans++;
                last = i;
            }
            map.put(sum, i);
        }
        return ans;
    }
}
