package leetcode.leetcode15xx.leetcode1542;

import java.util.Arrays;

public class Solution2 {
    public int longestAwesome(String s) {
        int[] map = new int[1024];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[0] = -1;
        int ans = 0;
        int n = s.length();
        int current = 0;
        for (int i = 0; i < n; i++) {
            current ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j <= 9; j++) {
                int key = (1 << j) ^ current;
                if (map[key] != Integer.MAX_VALUE) ans = Math.max(ans, i - map[key]);
            }
            if (map[current] != Integer.MAX_VALUE) {
                ans = Math.max(ans, i - map[current]);
            } else map[current] = i;
        }
        return ans;
    }
}
