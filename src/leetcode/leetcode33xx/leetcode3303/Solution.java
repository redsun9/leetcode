package leetcode.leetcode33xx.leetcode3303;

public class Solution {
    public int minStartingIndex(String s, String p) {
        char[] sArr = s.toCharArray(), pArr = p.toCharArray();
        int m = p.length(), n = s.length();

        char[] arr = new char[m + 1 + n];
        System.arraycopy(pArr, 0, arr, 0, m);
        System.arraycopy(sArr, 0, arr, m + 1, n);
        arr[m] = '#';
        int[] z1 = zFunction(arr);

        reverse(sArr);
        reverse(pArr);
        System.arraycopy(pArr, 0, arr, 0, m);
        System.arraycopy(sArr, 0, arr, m + 1, n);
        arr[m] = '#';
        int[] z2 = zFunction(arr);

        for (int i = m + 1, j = n + 1; j > m; i++, j--) {
            if (z1[i] + z2[j] + 1 >= m) {
                return i - m - 1;
            }
        }
        return -1;

    }

    private static void reverse(char[] arr) {
        char tmp;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    // z[i] = k => s[0..k) == s[i..i+k)
    private static int[] zFunction(char[] s) {
        int n = s.length;
        int[] zf = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            zf[i] = Math.max(0, Math.min(right - i, zf[i - left]));
            while (i + zf[i] < n && s[zf[i]] == s[i + zf[i]]) zf[i]++;
            if (i + zf[i] > right) {
                left = i;
                right = i + zf[i];
            }
        }
        return zf;
    }
}
