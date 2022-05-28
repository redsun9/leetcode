package leetcode.leetcode22xx.leetcode2283;

public class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        if (n > 10) return false;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) count[num.charAt(i) - '0']++;
        for (int i = 0; i < n; i++) if (count[i] != num.charAt(i) - '0') return false;
        for (int i = n; i < 10; i++) if (count[i] != 0) return false;
        return true;
    }
}
