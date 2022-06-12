package basic;

import basic.utils.IntegerUtils;

import java.util.Arrays;

public class FastFourierTransform {
    public static int[] multiply(int[] a, int[] b) {
        int m = a.length + b.length - 1;
        int n = IntegerUtils.nextPow2(m);
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
        for (int i = 0; i < m; i++) res[i] = (int) Math.round(fa[i].getReal());
        return res;
    }


    public static int[] modularMultiply(int[] a, int[] b) {
        return modularMultiply(a, b, 7340033, 5, 4404020, 1 << 20);
    }

    public static int[] modularMultiply(int[] a, int[] b, int mod, int root, int root1, int rootPw) {
        int m = a.length + b.length - 1;
        int n = IntegerUtils.nextPow2(m);
        int[] fa = Arrays.copyOf(a, n), fb = Arrays.copyOf(b, n);
        nft(fa, false, mod, root, root1, rootPw);
        nft(fb, false, mod, root, root1, rootPw);
        for (int i = 0; i < n; i++) fa[i] = (int) (((long) fa[i] * fb[i]) % mod);
        nft(fa, true, mod, root, root1, rootPw);
        return Arrays.copyOf(fa, m);
    }

    public static ComplexDouble[] multiply(ComplexDouble[] a, ComplexDouble[] b) {
        int m = a.length + b.length - 1;
        int n = IntegerUtils.nextPow2(m);
        ComplexDouble[] fa = Arrays.copyOf(a, n);
        ComplexDouble[] fb = Arrays.copyOf(b, n);
        Arrays.fill(fa, a.length, n, ComplexDouble.ZERO);
        Arrays.fill(fb, b.length, n, ComplexDouble.ZERO);
        fft(fa, false);
        fft(fb, false);
        for (int i = 0; i < n; i++) fa[i] = fa[i].multiply(fb[i]);
        fft(fa, true);
        return Arrays.copyOf(fa, m);
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


    // for example mod = 7340033, root = 5, root1 = 4404020, rootPw = 1 << 20;
    public static void nft(int[] a, boolean inverse, int mod, int root, int root1, int rootPw) {
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
                for (int j = 0; j < len / 2; j++) {
                    int u = a[i + j], v = (int) ((long) a[i + j + len / 2] * w % mod);
                    a[i + j] = u + v < mod ? u + v : u + v - mod;
                    a[i + j + len / 2] = u - v >= 0 ? u - v : u - v + mod;
                    w = (int) ((long) w * wlen % mod);
                }
            }
        }
        if (inverse) {
            int inv = IntegerUtils.reverse(n, mod);
            for (int i = 0; i < n; i++) a[i] = (int) ((long) a[i] * inv % mod);
        }
    }
}
