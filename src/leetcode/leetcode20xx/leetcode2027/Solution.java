package leetcode.leetcode20xx.leetcode2027;

public class Solution {
    public int minimumMoves(String s) {
        int ans = 0, n = s.length(), i = 0;
        while (i < n) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 3;
            } else i++;
        }
        return ans;
    }
}
