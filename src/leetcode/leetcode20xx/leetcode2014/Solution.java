package leetcode.leetcode20xx.leetcode2014;

import java.util.Arrays;

public class Solution {
    private static final int MAX_SEQ_LENGTH = 7;

    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] arr = new int[n];
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            arr[i] = c;
            count[c]++;
        }

        int numberOfChars = 0, maxNumberOfChars = 0;
        int[][] chars = new int[8][2];
        int[] max = {0, 0};
        for (int i = 25; i >= 0; i--) {
            if (count[i] >= k) {
                int times = count[i] / k;
                chars[numberOfChars][0] = i;
                chars[numberOfChars][1] = times;
                numberOfChars++;
                maxNumberOfChars += times;
                if (times > max[1]) {
                    max[0] = i;
                    max[1] = times;
                }
            }
        }
        if (numberOfChars == 0) return "";
        if (numberOfChars == 1) return create(max[0], max[1]);

        int[] ans = new int[maxNumberOfChars];
        int ansLength = max[1];
        Arrays.fill(ans, 0, max[1], max[0]);

        int[] tmp = new int[maxNumberOfChars];
        for (int val = ansLength + 1; val <= maxNumberOfChars; val++) {
            if (!dfs(0, tmp, val, chars, numberOfChars, arr, n, k)) break;
            System.arraycopy(tmp, 0, ans, 0, val);
            ansLength = val;
        }
        return create(ans, ansLength);
    }

    private static boolean dfs(int pos, int[] tmp, int val, int[][] count, int m, int[] arr, int n, int k) {
        if (pos == val) return check(arr, tmp, n, val, k);
        for (int i = 0; i < m; i++) {
            if (count[i][1] == 0) continue;
            count[i][1]--;
            tmp[pos] = count[i][0];
            boolean found = dfs(pos + 1, tmp, val, count, m, arr, n, k);
            count[i][1]++;
            if (found) return true;
        }
        return false;
    }


    private static String create(int c, int count) {
        char[] ans = new char[count];
        Arrays.fill(ans, (char) (c + 'a'));
        return new String(ans);
    }

    private static String create(int[] a, int n) {
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) ans[i] = (char) (a[i] + 'a');
        return new String(ans);
    }

    private static boolean check(int[] a, int[] b, int n, int m, int k) {
        int i = 0, j = 0, left = n - m * k;
        while (left >= 0 && k > 0) {
            if (a[i++] == b[j]) {
                if (++j == m) {
                    j = 0;
                    k--;
                }
            } else left--;
        }
        return k == 0;
    }
}
