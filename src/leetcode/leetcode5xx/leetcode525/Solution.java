package leetcode.leetcode5xx.leetcode525;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> firstPos = new HashMap<>();
        firstPos.put(0, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (firstPos.containsKey(sum)) {
                ans = Math.max(ans, i - firstPos.get(sum));
            } else {
                firstPos.put(sum, i);
            }
        }
        return ans;
    }
}
