package leetcode.leetcode37xx.leetcode3707;

public class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length(), total = n;
        for (int i = 0; i < n; i++) {
            total += s.charAt(i) - 'a';
        }
        if ((total & 1) != 0) return false;
        total >>= 1;
        for (int i = 0; i < n; i++) {
            total -= s.charAt(i) - 'a' + 1;
            if (total <= 0) return total == 0;
        }
        return false;
    }
}
