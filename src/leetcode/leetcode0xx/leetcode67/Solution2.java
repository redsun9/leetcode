package leetcode.leetcode0xx.leetcode67;

public class Solution2 {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length(), k = Math.max(m, n) + 1;
        char[] ans = new char[k];

        for (int i1 = m - 1, i2 = n - 1, i3 = k - 1, sum = 0; i3 >= 0; i1--, i2--, i3--, sum >>>= 1) {
            sum += i1 >= 0 && a.charAt(i1) == '1' ? 1 : 0;
            sum += i2 >= 0 && b.charAt(i2) == '1' ? 1 : 0;
            ans[i3] = (char) ('0' + (sum & 1));
        }

        if (ans[0] != '0') return new String(ans);
        else return new String(ans, 1, k - 1);
    }
}