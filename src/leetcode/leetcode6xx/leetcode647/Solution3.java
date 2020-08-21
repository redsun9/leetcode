package leetcode.leetcode6xx.leetcode647;

/*
    Manacher's algorithm
 */
public class Solution3 {
    public int countSubstrings(String s) {
        int[] d1 = calculate1(s);
        int[] d2 = calculate2(s);
        int ans = 0;
        for (int d : d1) ans += d;
        for (int d : d2) ans += d;
        return ans + s.length();
    }

    int[] calculate1(String s) {
        int n = s.length();
        int l = 0;
        int r = -1;
        int[] d1 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = 0;
            if (i <= r) k = Math.min(r - i, d1[r - i + l]);
            while (i + k + 1 <= n && i - k - 1 > 0 && s.charAt(i + k) == s.charAt(i - k - 2)) k++;
            d1[i] = k;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return d1;
    }

    int[] calculate2(String s) {
        int n = s.length();
        int l = 0;
        int r = -1;
        int[] d2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = 0;
            if (i <= r) k = Math.min(r - i + 1, d2[r - i + l + 1]);
            while (i + k <= n && i - k - 1 > 0 && s.charAt(i + k - 1) == s.charAt(i - k - 2)) k++;
            d2[i] = k;
            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }
        }
        return d2;
    }

}
