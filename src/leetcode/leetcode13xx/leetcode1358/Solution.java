package leetcode.leetcode13xx.leetcode1358;

public class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if (n < 3) return 0;
        int lastAB = 0, lastAC = 0, lastBC = 0, lastA = 0, lastB = 0, lastC = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                ans += lastBC;
                lastA = i + 1;
                lastAB = Math.min(lastA, lastB);
                lastAC = Math.min(lastA, lastC);
            } else if (c == 'b') {
                ans += lastAC;
                lastB = i + 1;
                lastAB = Math.min(lastA, lastB);
                lastBC = Math.min(lastB, lastC);
            } else {
                ans += lastAB;
                lastC = i + 1;
                lastAC = Math.min(lastA, lastC);
                lastBC = Math.min(lastB, lastC);
            }
        }
        return ans;
    }
}
