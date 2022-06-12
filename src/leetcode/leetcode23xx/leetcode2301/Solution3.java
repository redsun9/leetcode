package leetcode.leetcode23xx.leetcode2301;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution3 {
    private static final int ALPHABET_SIZE = 62;

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

        double[][] arr1 = new double[2][t], arr2 = new double[2][t];
        double[] re1 = arr1[0], re2 = arr2[0], im1 = arr1[1], im2 = arr2[1];
        for (int c1 = 0, c2 = 1; c1 < ALPHABET_SIZE; c1 += 2, c2 += 2) {
            for (int i = 0; i < n; i++) re1[i] = a[i] == c1 ? 1 : 0;
            for (int i = 0, j = m - 1; i < m; i++, j--) re2[j] = map[b[i]][c1] ? 0 : 1;
            Arrays.fill(re1, n, t, 0);
            Arrays.fill(re2, m, t, 0);
            if (c2 < ALPHABET_SIZE) {
                for (int i = 0; i < n; i++) im1[i] = a[i] == c2 ? 1 : 0;
                for (int i = 0, j = m - 1; i < m; i++, j--) im2[j] = map[b[i]][c2] ? 0 : -1;
                Arrays.fill(im1, n, t, 0);
                Arrays.fill(im2, m, t, 0);
            } else {
                Arrays.fill(im1, 0);
                Arrays.fill(im2, 0);
            }
            multiply(arr1, arr2);
            for (int i = 0, j = m - 1; i < k; i++, j++) result[i] |= Math.round(re1[j]);
        }
        for (long val : result) if (val == 0) return true;
        return false;
    }

    private static int idx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        else return c - '0' + 52;
    }


    public static void multiply(double[][] a, double[][] b) {
        double[] re1 = a[0], re2 = b[0], im1 = a[1], im2 = b[1];
        int n = re1.length;
        fft(a, false);
        fft(b, false);
        for (int i = 0; i < n; i++) {
            double x = re1[i] * re2[i] - im1[i] * im2[i];
            double y = re1[i] * im2[i] + im1[i] * re2[i];
            re1[i] = x;
            im1[i] = y;
        }
        fft(a, true);
    }

    private static void fft(double[][] a, boolean inverse) {
        double[] re = a[0], im = a[1];
        int n = re.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                double temp = re[i];
                re[i] = re[j];
                re[j] = temp;
                temp = im[i];
                im[i] = im[j];
                im[j] = temp;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (inverse ? -1 : 1);
            double wlenX = Math.cos(ang), wlenY = Math.sin(ang);
            for (int i = 0; i < n; i += len) {
                double wx = 1, wy = 0;
                for (int j = 0, j1 = i + j, j2 = i + j + len / 2; j < len / 2; j++, j1++, j2++) {
                    double ux = re[j1], uy = im[j1];
                    double vx = re[j2] * wx - im[j2] * wy;
                    double vy = re[j2] * wy + im[j2] * wx;
                    re[j1] = ux + vx;
                    im[j1] = uy + vy;
                    re[j2] = ux - vx;
                    im[j2] = uy - vy;
                    double tx = wx * wlenX - wy * wlenY;
                    double ty = wx * wlenY + wy * wlenX;
                    wx = tx;
                    wy = ty;
                }
            }
        }
        double invn = 1.0 / n;
        if (inverse) for (int i = 0; i < n; i++) {
            re[i] *= invn;
            im[i] *= invn;
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
