package leetcode.leetcode15xx.leetcode1542;

import java.util.HashMap;

public class Solution {
    public int longestAwesome(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int n = s.length();
        int current = 0;
        for (int i = 0; i < n; i++) {
            current ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j <= 9; j++) {
                int key = (1 << j) ^ current;
                if (map.containsKey(key)) ans = Math.max(ans, i - map.get(key));
            }
            if (map.containsKey(current)) {
                ans = Math.max(ans, i - map.get(current));
            } else map.put(current, i);
        }
        return ans;
    }
}
