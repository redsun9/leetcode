package leetcode.leetcode7xx.leetcode777;

public class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        String a = start.replace("X", "");
        String b = end.replace("X", "");
        if (!a.equals(b)) return false;
        int tmp1 = 0;
        int tmp2 = 0;
        while (tmp1 < start.length()) {
            int r1 = start.indexOf('R', tmp1);
            int r2 = end.indexOf('R', tmp2);
            if (r1 < 0) break;
            if (r1 > r2) return false;
            tmp1 = r1 + 1;
            tmp2 = r2 + 1;
        }
        tmp1 = 0;
        tmp2 = 0;
        while (tmp1 < start.length()) {
            int r1 = start.indexOf('L', tmp1);
            int r2 = end.indexOf('L', tmp2);
            if (r1 < 0) break;
            if (r1 < r2) return false;
            tmp1 = r1 + 1;
            tmp2 = r2 + 1;
        }
        return true;
    }
}
