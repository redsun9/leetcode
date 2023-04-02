package leetcode.leetcode26xx.leetcode2609;

public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0, cntOne = 0, cntZero = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (cntOne != 0) {
                    cntZero = 1;
                    cntOne = 0;
                } else cntZero++;
            } else {
                cntOne++;
                ans = Math.max(ans, Math.min(cntOne, cntZero) * 2);
            }
        }
        return ans;
    }
}
