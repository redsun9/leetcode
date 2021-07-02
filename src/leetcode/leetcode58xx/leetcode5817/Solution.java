package leetcode.leetcode58xx.leetcode5817;

public class Solution {
    public boolean isDecomposable(String s) {
        int n = s.length();
        if (n % 3 != 2) return false;
        boolean used = false;
        int left = 0, right = 1, mod;
        char c = s.charAt(0);
        while (true) {
            while (right != n && s.charAt(right) == c) right++;
            mod = (right - left) % 3;
            if (mod == 2) {
                if (used) return false;
                used = true;
            } else if (mod == 1) return false;
            if (right == n) return used;
            left = right;
            c = s.charAt(right++);
        }
    }
}
