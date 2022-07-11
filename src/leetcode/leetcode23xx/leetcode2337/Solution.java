package leetcode.leetcode23xx.leetcode2337;

public class Solution {
    private static boolean checkOrder(String s1, String s2) {
        int n = s1.length();
        int i1 = 0, i2 = 0;
        while (true) {
            while (i1 < n && s1.charAt(i1) == '_') i1++;
            while (i2 < n && s2.charAt(i2) == '_') i2++;
            if (i1 == n && i2 == n) return true;
            if (i1 == n || i2 == n) return false;
            if (s1.charAt(i1++) != s2.charAt(i2++)) return false;
        }
    }

    public boolean canChange(String start, String target) {
        if (!checkOrder(start, target)) return false;
        int needLInStart = 0;
        int needRInTarget = 0;
        int n = start.length();
        char c1, c2;
        for (int i = 0; i < n; i++) {
            c1 = start.charAt(i);
            c2 = target.charAt(i);
            if (needLInStart > 0 && c1 == 'R') return false;
            if (needRInTarget > 0 && c2 == 'L') return false;
            if (c2 == 'L') needLInStart++;
            if (c1 == 'R') needRInTarget++;
            if (c1 == 'L') needLInStart--;
            if (c2 == 'R') needRInTarget--;
            if (needLInStart < 0 || needRInTarget < 0) return false;
        }
        return needLInStart == 0 && needRInTarget == 0;
    }
}
