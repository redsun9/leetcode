package leetcode.leetcode23xx.leetcode2301;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution4 {
    static final int ALPHABET_SIZE = 62, mod = 7340033, root = 5, root1 = 4404020, rootPw = 1 << 20;

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] map = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];
        for (char[] mapping : mappings) map[idx(mapping[0])][idx(mapping[1])] = true;
        for (int i = 0; i < ALPHABET_SIZE; i++) map[i][i] = true;
        int n = s.length(), m = sub.length();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) a[i] = idx(s.charAt(i));
        for (int i = 0; i < m; i++) b[i] = idx(sub.charAt(i));

        int k = n - m + 1, t = nextPow2(n + m - 1);
        long[] result = new long[k];

        int[] arr1 = new int[t], arr2 = new int[t];
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            for (int i = 0, j = n - 1; i < n; i++, j--) arr1[i] = a[j] == c ? 1 : 0;
            for (int i = 0; i < m; i++) arr2[i] = map[b[i]][c] ? 0 : 1;
            Arrays.fill(arr1, n, t, 0);
            Arrays.fill(arr2, m, t, 0);
            modularMultiply(arr1, arr2);
            for (int i = 0, j = m - 1; i < k; i++, j++) result[i] |= arr1[j];
        }
        for (long val : result) if (val == 0) return true;
        return false;
    }

    private static int idx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        else return c - '0' + 52;
    }


    private static void modularMultiply(int[] a, int[] b) {
        int n = a.length;
        nft(a, false);
        nft(b, false);
        for (int i = 0; i < n; i++) a[i] = (int) (((long) a[i] * b[i]) % mod);
        nft(a, true);
    }

    private static void nft(int[] a, boolean inverse) {
        int n = a.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            int wlen = inverse ? root1 : root;
            for (int i = len; i < rootPw; i <<= 1)
                wlen = (int) ((long) wlen * wlen % mod);

            for (int i = 0; i < n; i += len) {
                int w = 1;
                for (int j = 0, j1 = i + j, j2 = i + j + len / 2; j < len / 2; j++, j1++, j2++) {
                    int u = a[j1], v = (int) ((long) a[j2] * w % mod);
                    a[j1] = u + v;
                    if (a[j1] >= mod) a[j1] -= mod;
                    a[j2] = u - v;
                    if (a[j2] < 0) a[j2] += mod;
                    w = (int) ((long) w * wlen % mod);
                }
            }
        }
        if (inverse) {
            int inv = reverse(n);
            for (int i = 0; i < n; i++) a[i] = (int) ((long) a[i] * inv % mod);
        }
    }


    private static int reverse(int a) {
        int t = 0, newT = 1, r = mod, newR = a, q, tmp;
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
        if (t < 0) t += mod;
        return t;
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
