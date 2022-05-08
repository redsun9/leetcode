package leetcode.leetcode22xx.leetcode2264;

public class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        if (n <= 2) return "";
        int max = -1;
        for (int r = 0, cur = 0, l = 0; r < n; r++) {
            cur = cur * 10 + num.charAt(r) - '0';
            if (r - l == 3) cur = cur - (num.charAt(l++) - '0') * 1000;
            if (r - l == 2 && cur % 111 == 0 && cur > max) max = cur;
        }
        return max == -1 ? "" : max == 0 ? "000" : String.valueOf(max);
    }
}
