package leetcode.leetcode11xx.leetcode1124;

import java.util.HashMap;

public class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int current = 0;
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            current += hours[i] > 8 ? 1 : -1;
            if (current > 0) ans = i + 1;
            else {
                ans = Math.max(ans, i - map.getOrDefault(current - 1, i));
                map.putIfAbsent(current, i);
            }
        }
        return ans;
    }
}
