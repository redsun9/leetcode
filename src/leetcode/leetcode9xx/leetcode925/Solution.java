package leetcode.leetcode9xx.leetcode925;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        int r1 = 0, r2 = 0;
        while (r1 < m && r2 < n) {
            int l1 = r1;
            char c = name.charAt(r1++);
            while (r1 < m && name.charAt(r1) == c) r1++;
            int l2 = r2;
            while (r2 < n && typed.charAt(r2) == c) r2++;
            if (r2 - l2 < r1 - l1) return false;
        }
        return (r1 == m) == (r2 == n);
    }
}
