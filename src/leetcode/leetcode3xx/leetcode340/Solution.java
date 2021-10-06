package leetcode.leetcode3xx.leetcode340;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, left = 0, n = s.length(), curr = 0;
        for (int right = 0; right < n; right++) {
            Integer prevVal = map.put(s.charAt(right), right);
            if (prevVal == null || prevVal < left) curr++;
            while (curr > k) {
                if (map.get(s.charAt(left)) == left) curr--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
