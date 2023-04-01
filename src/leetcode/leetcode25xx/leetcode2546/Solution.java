package leetcode.leetcode25xx.leetcode2546;

public class Solution {
    public boolean makeStringsEqual(String s, String target) {
        return allZero(s) == allZero(target);
    }

    private static boolean allZero(String a) {
        int n = a.length();
        for (int i = 0; i < n; i++) if (a.charAt(i) != '0') return false;
        return true;
    }
}
