package leetcode.leetcode15xx.leetcode1541;

public class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int curr = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (curr % 2 != 0) {
                    curr--;
                    ans++;
                }
                curr += 2;
            } else {
                curr--;
                if (curr < 0) {
                    curr += 2;
                    ans++;
                }
            }
        }
        return ans + curr;
    }
}
