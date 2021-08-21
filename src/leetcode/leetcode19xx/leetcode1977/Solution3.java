package leetcode.leetcode19xx.leetcode1977;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
class Solution3 {
    private static final int p = 1_000_000_007;

    public int numberOfCombinations(String num) {
        int n = num.length();
        if (num.charAt(0) == '0') return 0;
        if (n == 1) return 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = num.charAt(i) - '0' + 1;

        int[] suffixArray = SuffixArrayTools.buildSuffixArray(arr, 10);
        int[] invSuffixArray = SuffixArrayTools.inverseSuffixArray(suffixArray);
        int[] lcp = SuffixArrayTools.buildLongestCommonPrefixArray(arr, suffixArray, invSuffixArray);
        SegmentTree tree = new SegmentTree(lcp);

        long[] prev = new long[n + 1], next = new long[n + 1], tmp;
        prev[0] = 1;
        next[0] = 1;

        for (int d = 1; d <= n; d++) {
            System.arraycopy(prev, 1, next, 1, n);
            for (int j1 = 0, i1 = j1 - d, j2 = j1 + d; j2 <= n; j1++, j2++, i1++) {
                if (arr[j1] != 1) {
                    if (i1 < 0 || arr[i1] != 1 && ok(i1, j1, d, invSuffixArray, lcp, tree))
                        next[j2] += next[j1];
                    else next[j2] += prev[j1];
                    if (next[j2] >= p) next[j2] -= p;
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return (int) prev[n];
    }


    private static boolean ok(int start1, int start2, int len, int[] inv, int[] lcp, SegmentTree tree) {
        return inv[start1] < inv[start2] ||
                inv[start1] - 1 == inv[start2] && lcp[inv[start2]] >= len ||
                tree.query(inv[start2], inv[start1]) >= len;
    }

    private static class SuffixArrayTools {
        // s.length>=2, s[i]>=1, s[i]<=maxValue
        static int[] buildSuffixArray(int[] arr, int K) {
            int n = arr.length;
            int[] s = Arrays.copyOf(arr, n + 3);
            int[] SA = new int[n];
            suffixArray(s, SA, n, K);
            return SA;
        }

        static int[] inverseSuffixArray(int[] suffixArray) {
            int n = suffixArray.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) ans[suffixArray[i]] = i;
            return ans;
        }

        static int[] buildLongestCommonPrefixArray(int[] arr, int[] suffixArray, int[] invSuffixArray) {
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
        static boolean leq(int a1, int a2, int b1, int b2) {
            return (a1 < b1 || (a1 == b1 && a2 <= b2));
        }

        //Lexicographic order for triples.
        static boolean leq(int a1, int a2, int a3, int b1, int b2, int b3) {
            return (a1 < b1 || (a1 == b1 && leq(a2, a3, b2, b3)));
        }

        static void suffixArray(int[] s, int[] SA, int n, int K) {
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

        static int getI(int[] SA12, int n0, int t) {
            return SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2;
        }

        static void radixPass(int[] a, int[] b, int[] r, int shift, int n, int K) {
            int[] c = new int[K + 1]; // counter array
            for (int i = 0; i < n; i++) c[r[a[i] + shift]]++; // count occurrences
            for (int i = 0, sum = 0; i <= K; i++) { // exclusive prefix sums
                int t = c[i];
                c[i] = sum;
                sum += t;
            }
            for (int i = 0; i < n; i++) b[c[r[a[i] + shift]]++] = a[i];
        }
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