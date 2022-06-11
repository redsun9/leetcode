package leetcode.leetcode22xx.leetcode2299;

public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        for (int i = 1; i < n; i++) if (password.charAt(i) == password.charAt(i - 1)) return false;
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else hasSpecial = true;
        }
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
