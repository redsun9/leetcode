package leetcode.leetcode24xx.leetcode2438;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static final int p = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        int d = Integer.bitCount(n);
        int[] powers = new int[d];
        for (int i = 30, j = d - 1; j >= 0; i--) if ((n >> i & 1) == 1) powers[j--] = 1 << i;
        long[] prefMult = new long[d + 1];
        long[] prefMultReverse = new long[d + 1];
        prefMult[0] = 1;
        prefMultReverse[0] = 1;
        for (int i = 0; i < d; i++) prefMult[i + 1] = prefMult[i] * powers[i] % p;
        for (int i = 1; i < d; i++) prefMultReverse[i] = reverse((int) prefMult[i]);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) ans[i] = (int) (prefMult[queries[i][1] + 1] * prefMultReverse[queries[i][0]] % p);
        return ans;
    }


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
}
