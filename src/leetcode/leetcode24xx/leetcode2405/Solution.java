package leetcode.leetcode24xx.leetcode2405;

import java.util.Arrays;

public class Solution {
    public int partitionString(String s) {
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        int ans = 1, n = s.length(), c;
        for (int l = 0, r = 0; r < n; r++) {
            c = s.charAt(r) - 'a';
            if (lastPos[c] >= l) {
                ans++;
                l = r;
            }
            lastPos[c] = r;
        }
        return ans;
    }
}
