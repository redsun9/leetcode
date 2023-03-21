package tcs_algo_course;

import java.util.Arrays;

public class SubstringEqualityLCP {
    private static final int ALPHABET_SIZE = 52;
    private final int[] inv;
    private final int[] lcp;
    private final SegmentTree tree;

    public SubstringEqualityLCP(String s) {
        int[] arr = convertToArray(s);
        int[] sa = buildSuffixArray(arr, ALPHABET_SIZE); //sorted starts
        this.inv = inverseSuffixArray(sa); //position to order
        this.lcp = buildLongestCommonPrefixArray(arr, sa, inv); //common prefix between i-th and i-1-th place
        this.tree = new SegmentTree(lcp);
    }

    public boolean isEqual(int a, int b, int c, int d) {
        if (b - a != d - c) return false;
        if (a == c) return true;
        int inv1 = inv[a], inv2 = inv[c], len = b - a;
        int left = Math.min(inv1, inv2), right = Math.max(inv1, inv2);
        return right - 1 == left && lcp[left] >= len || tree.query(left, right) >= len;
    }

    private static int[] convertToArray(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') arr[i] = 1 + c - 'a';
            else arr[i] = 27 + c - 'A';
        }
        return arr;
    }

    // s.length>=2, s[i]>=1, s[i]<=maxValue
    private static int[] buildSuffixArray(int[] arr, int K) {
        int n = arr.length;
        int[] s = Arrays.copyOf(arr, n + 3);
        int[] SA = new int[n];
        suffixArray(s, SA, n, K);
        return SA;
    }

    private static int[] inverseSuffixArray(int[] suffixArray) {
        int n = suffixArray.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[suffixArray[i]] = i;
        return ans;
    }

    private static int[] buildLongestCommonPrefixArray(int[] arr, int[] suffixArray, int[] invSuffixArray) {
        int n = arr.length;
        int[] lcp = new int[n - 1];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (k > 0) k--;
            if (invSuffixArray[i] == n - 1) {
                k = 0;
            } else {
                int j = suffixArray[invSuffixArray[i] + 1];
                while (i + k < n && j + k < n && arr[i + k] == arr[j + k]) k++;
                lcp[invSuffixArray[i]] = k;
            }
        }
        return lcp;
    }

    //Lexicographic order for pairs.
    private static boolean leq(int a1, int a2, int b1, int b2) {
        return (a1 < b1 || (a1 == b1 && a2 <= b2));
    }

    //Lexicographic order for triples.
    private static boolean leq(int a1, int a2, int a3, int b1, int b2, int b3) {
        return (a1 < b1 || (a1 == b1 && leq(a2, a3, b2, b3)));
    }

    private static void suffixArray(int[] s, int[] SA, int n, int K) {
        int n0 = (n + 2) / 3, n1 = (n + 1) / 3, n2 = n / 3, n02 = n0 + n2;
        int[] s12 = new int[n02 + 3], SA12 = new int[n02 + 3], s0 = new int[n0], SA0 = new int[n0];

        for (int i = 0, j = 0; i < n + (n0 - n1); i++) if (i % 3 != 0) s12[j++] = i;

        radixPass(s12, SA12, s, 2, n02, K);
        radixPass(SA12, s12, s, 1, n02, K);
        radixPass(s12, SA12, s, 0, n02, K);

        // find lexicographic names of triples
        int name = 0, c0 = -1, c1 = -1, c2 = -1;
        for (int i = 0; i < n02; i++) {
            if (s[SA12[i]] != c0 || s[SA12[i] + 1] != c1 || s[SA12[i] + 2] != c2) {
                name++;
                c0 = s[SA12[i]];
                c1 = s[SA12[i] + 1];
                c2 = s[SA12[i] + 2];
            }
            if (SA12[i] % 3 == 1) {
                s12[SA12[i] / 3] = name;
            } // left half
            else {
                s12[SA12[i] / 3 + n0] = name;
            } // right half
        }

        // recurse if names are not yet unique
        if (name < n02) {
            suffixArray(s12, SA12, n02, name);
            // store unique names in s12 using the suffix array
            for (int i = 0; i < n02; i++) s12[SA12[i]] = i + 1;
        } else // generate the suffix array of s12 directly
            for (int i = 0; i < n02; i++) SA12[s12[i] - 1] = i;

        // stably sort the mod 0 suffixes from SA12 by their first character
        for (int i = 0, j = 0; i < n02; i++) if (SA12[i] < n0) s0[j++] = 3 * SA12[i];
        radixPass(s0, SA0, s, 0, n0, K);

        // merge sorted SA0 suffixes and sorted SA12 suffixes
        for (int p = 0, t = n0 - n1, k = 0; k < n; k++) {
            int i = getI(SA12, n0, t); // pos of current offset 12 suffix
            int j = SA0[p]; // pos of current offset 0 suffix
            if (SA12[t] < n0 ? // different compares for mod 1 and mod 2 suffixes
                    leq(s[i], s12[SA12[t] + n0], s[j], s12[j / 3]) :
                    leq(s[i], s[i + 1], s12[SA12[t] - n0 + 1], s[j], s[j + 1], s12[j / 3 + n0])
            ) {// suffix from SA12 is smaller
                SA[k] = i;
                t++;
                if (t == n02) // done --- only SA0 suffixes left
                    for (k++; p < n0; p++, k++) SA[k] = SA0[p];
            } else {// suffix from SA0 is smaller
                SA[k] = j;
                p++;
                if (p == n0) // done --- only SA12 suffixes left
                    for (k++; t < n02; t++, k++) SA[k] = getI(SA12, n0, t);
            }
        }
    }

    private static int getI(int[] SA12, int n0, int t) {
        return SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2;
    }

    private static void radixPass(int[] a, int[] b, int[] r, int shift, int n, int K) {
        int[] c = new int[K + 1]; // counter array
        for (int i = 0; i < n; i++) c[r[a[i] + shift]]++; // count occurrences
        for (int i = 0, sum = 0; i <= K; i++) { // exclusive prefix sums
            int t = c[i];
            c[i] = sum;
            sum += t;
        }
        for (int i = 0; i < n; i++) b[c[r[a[i] + shift]]++] = a[i];
    }

    private static class SegmentTree {
        private final int[] t;
        private final int n;

        SegmentTree(int[] arr) {
            this.n = nextPow2(arr.length);
            this.t = new int[n * 2 - 1];
            Arrays.fill(t, Integer.MAX_VALUE);
            System.arraycopy(arr, 0, t, n - 1, arr.length);
            for (int i = n - 2; i >= 0; i--) t[i] = Math.min(t[2 * i + 1], t[2 * i + 2]);
        }

        int query(int l, int r) {
            return query(0, 0, n, l, r);
        }

        private int query(int v, int l, int r, int ql, int qr) {
            if (l >= qr || r <= ql) return Integer.MAX_VALUE;
            if (ql <= l && r <= qr) return t[v];
            int mid = (l + r) / 2;
            return Math.min(
                    query(v * 2 + 1, l, mid, ql, qr),
                    query(v * 2 + 2, mid, r, ql, qr)
            );
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
