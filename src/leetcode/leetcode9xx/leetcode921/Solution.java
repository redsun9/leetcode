package leetcode.leetcode9xx.leetcode921;

public class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, curr = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') curr++;
            else if (curr-- == 0) {
                ans++;
                curr = 0;
            }
        }
        return ans + curr;
    }
}
