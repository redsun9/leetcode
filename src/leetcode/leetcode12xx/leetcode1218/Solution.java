package leetcode.leetcode12xx.leetcode1218;

import java.util.HashMap;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            int prev = map.getOrDefault(a - difference, 0) + 1;
            ans = Math.max(ans, map.compute(a, (key, val) -> {
                if (val == null) return prev;
                return Math.max(val, prev);
            }));
        }
        return ans;
    }
}
