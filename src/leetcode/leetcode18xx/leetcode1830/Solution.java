package leetcode.leetcode18xx.leetcode1830;

public class Solution {
    private static final int p = 1_000_000_007;

    public static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += p;
        return t;
    }

    public int makeStringSorted(String s) {
        int n = s.length();
        if (n == 1) return 0;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        factorials[1] = 1;
        for (int i = 2; i <= n; i++) factorials[i] = (int) ((long) factorials[i - 1] * i % p);

        long tmp = factorials[n];
        for (int c : count) tmp = tmp * reverse(factorials[c]) % p;

        int ans = 0;
        for (int i = 0, j = n; i < n - 1; i++, j--) {
            int c = s.charAt(i) - 'a';
            tmp = tmp * reverse(j) % p;
            for (int k = 0; k < c; k++) ans = (int) ((ans + tmp * count[k]) % p);
            tmp = tmp * count[c] % p;
            count[c]--;
        }
        return ans;
    }
}
