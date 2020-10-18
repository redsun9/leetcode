package leetcode.leetcode16xx.leetcode1624;

import java.util.Arrays;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        if (n <= 1) return -1;
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, n);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            ans = Math.max(ans, i - lastPos[c] - 1);
            lastPos[c] = Math.min(lastPos[c], i);
        }
        return ans;
    }
}
