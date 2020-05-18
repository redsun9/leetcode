package leetcode.leetcode13xx.leetcode1371;

public class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        Integer[] pos = new Integer[32];
        pos[0] = -1;
        int ans = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int b = -1;
            if (c == 'a') b = 0;
            else if (c == 'e') b = 1;
            else if (c == 'i') b = 2;
            else if (c == 'o') b = 3;
            else if (c == 'u') b = 4;
            if (b != -1) {
                tmp ^= 1 << b;
                if (pos[tmp] != null) ans = Math.max(ans, i - pos[tmp]);
                else pos[tmp] = i;
            } else ans = Math.max(ans, i - pos[tmp]);
        }
        return ans;
    }
}
