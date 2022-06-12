package leetcode.leetcode23xx.leetcode2301;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final int ALPHABET_SIZE = 62;

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] map = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];
        for (char[] mapping : mappings) map[idx(mapping[0])][idx(mapping[1])] = true;
        for (int i = 0; i < ALPHABET_SIZE; i++) map[i][i] = true;
        int n = s.length(), m = sub.length();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) a[i] = idx(s.charAt(i));
        for (int i = 0; i < m; i++) b[i] = idx(sub.charAt(i));

        int k = n - m + 1;
        long[] result = new long[k];

        int[] arr1 = new int[n], arr2 = new int[m];
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            for (int i = 0; i < n; i++) arr1[i] = a[i] == c ? 1 : 0;
            for (int i = 0, j = m - 1; i < m; i++, j--) arr2[j] = map[b[i]][c] ? 0 : 1;
            int[] multiply = multiply(arr1, arr2);
            long bit = 1L << c;
            for (int i = 0, j = m - 1; i < k; i++, j++) if (multiply[j] != 0) result[i] |= bit;
        }
        for (long val : result) if (val == 0) return true;
        return false;
    }

    private static int idx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        else return c - '0' + 52;
    }


    public static int[] multiply(int[] a, int[] b) {
        int m = a.length + b.length - 1;
        int n = nextPow2(m);
        ComplexDouble[] fa = new ComplexDouble[n], fb = new ComplexDouble[n];
        for (int i = 0; i < a.length; i++) fa[i] = new ComplexDouble(a[i], 0);
        for (int i = 0; i < b.length; i++) fb[i] = new ComplexDouble(b[i], 0);
        Arrays.fill(fa, a.length, n, ComplexDouble.ZERO);
        Arrays.fill(fb, b.length, n, ComplexDouble.ZERO);
        fft(fa, false);
        fft(fb, false);
        for (int i = 0; i < n; i++) fa[i] = fa[i].multiply(fb[i]);
        fft(fa, true);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) res[i] = (int) Math.round(fa[i].real);
        return res;
    }

    public static void fft(ComplexDouble[] a, boolean inverse) {
        int n = a.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                ComplexDouble temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (inverse ? -1 : 1);
            ComplexDouble wlen = new ComplexDouble(Math.cos(ang), Math.sin(ang));
            for (int i = 0; i < n; i += len) {
                ComplexDouble w = new ComplexDouble(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    ComplexDouble u = a[i + j], v = a[i + j + len / 2].multiply(w);
                    a[i + j] = u.add(v);
                    a[i + j + len / 2] = u.subtract(v);
                    w = w.multiply(wlen);
                }
            }
        }
        if (inverse) for (int i = 0; i < n; i++) a[i] = a[i].divide(n);
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    private record ComplexDouble(double real, double imaginary) {
        public static final ComplexDouble ZERO = new ComplexDouble(0, 0);

        public ComplexDouble add(ComplexDouble other) {
            return new ComplexDouble(real + other.real, imaginary + other.imaginary);
        }

        public ComplexDouble subtract(ComplexDouble other) {
            return new ComplexDouble(real - other.real, imaginary - other.imaginary);
        }

        public ComplexDouble multiply(ComplexDouble w) {
            return new ComplexDouble(real * w.real - imaginary * w.imaginary, real * w.imaginary + imaginary * w.real);
        }

        public ComplexDouble divide(int n) {
            return new ComplexDouble(real / n, imaginary / n);
        }
    }
}
