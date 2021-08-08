package leetcode.leetcode19xx.leetcode1963;

public class Solution {
    public int minSwaps(String s) {
        int n = s.length(), count = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') ans = Math.max(ans, ++count);
            else count--;
        }
        return (ans + 1) / 2;
    }
}
