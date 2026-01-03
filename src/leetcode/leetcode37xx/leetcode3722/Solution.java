package leetcode.leetcode37xx.leetcode3722;

public class Solution {
    public String lexSmallest(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        Key[] max = {new Key(0, n, 1)}, key;
        for (int k = 2; k <= n; k++) {
            key = new Key[]{new Key(k - 1, -1, -1), new Key(k, n, 1)};
            if (less(arr, key, max)) max = key;

            if (k != n) {
                key = new Key[]{new Key(0, n - k, 1), new Key(n - 1, n - 1 - k, -1)};
                if (less(arr, key, max)) max = key;
            }
        }
        return createFromKey(arr, max);
    }


    private static boolean less(char[] s, Key[] key1, Key[] key2) {
        int n = s.length;
        for (int i = 0, p1 = 0, p2 = 0, i1 = key1[0].start, i2 = key2[0].start, j1 = key1[0].end, j2 = key2[0].end, d1 = key1[0].step, d2 = key2[0].step; ; ) {
            if (s[i1] != s[i2]) return s[i1] < s[i2];

            i++;
            if (i == n) return false;

            i1 += d1;
            if (i1 == j1) {
                p1++;
                i1 = key1[p1].start;
                j1 = key1[p1].end;
                d1 = key1[p1].step;
            }

            i2 += d2;
            if (i2 == j2) {
                p2++;
                i2 = key2[p2].start;
                j2 = key2[p2].end;
                d2 = key2[p2].step;
            }
        }
    }

    private static String createFromKey(char[] s, Key[] key1) {
        int n = s.length;
        char[] ans = new char[n];
        for (int i = 0, p1 = 0, i1 = key1[0].start, j1 = key1[0].end, d1 = key1[0].step; ; ) {
            ans[i] = s[i1];

            i++;
            if (i == n) return new String(ans);

            i1 += d1;
            if (i1 == j1) {
                p1++;
                i1 = key1[p1].start;
                j1 = key1[p1].end;
                d1 = key1[p1].step;
            }
        }
    }

    private record Key(int start, int end, int step) {
    }
}
