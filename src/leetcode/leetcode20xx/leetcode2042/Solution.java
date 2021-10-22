package leetcode.leetcode20xx.leetcode2042;

public class Solution {
    public boolean areNumbersAscending(String s) {
        int n = s.length();
        int prev = -1;
        for (int i = 0, tmp = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') tmp = tmp * 10 + c - '0';
            if (c < '0' || c > '9' || i == n - 1) {
                if (tmp != 0) {
                    if (tmp <= prev) return false;
                    prev = tmp;
                    tmp = 0;
                }
            }
        }
        return true;
    }
}
