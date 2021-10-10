package basic.utils;

@SuppressWarnings("DuplicatedCode")
public class StringTools {
    public static int[] zFunction(String s) {
        int n = s.length();
        int[] zf = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            zf[i] = Math.max(0, Math.min(right - i, zf[i - left]));
            while (i + zf[i] < n && s.charAt(zf[i]) == s.charAt(i + zf[i])) zf[i]++;
            if (i + zf[i] > right) {
                left = i;
                right = i + zf[i];
            }
        }
        return zf;
    }

    public static int[] prefixFunction(String s) {
        int n = s.length();
        int[] p = new int[n];
        for (int i = 1; i < n; i++) {
            int k = p[i - 1];
            while (k > 0 && s.charAt(i) != s.charAt(k)) k = p[k - 1];
            if (s.charAt(i) == s.charAt(k)) k++;
            p[i] = k;
        }
        return p;
    }


    //number of palindromes of odd length with center at i
    public static int[] manacherOdd(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(ans[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return ans;
    }

    //number of palindromes of even length with center at i
    public static int[] manacherEven(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(ans[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        return ans;
    }

    //longest common subsequence
    public static String lcs(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        char[] ans = new char[dp[0][0]];
        int i = 0, j = 0, pos = 0;
        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j)) {
                ans[pos++] = x.charAt(i);
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) i++;
            else j++;
        }
        return new String(ans);
    }

    //longest common subsequence
    public static String lcs(String x, String y, String z) {
        int m = x.length(), n = y.length(), p = z.length();
        int[][][] dp = new int[m + 1][n + 1][p + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = p - 1; k >= 0; k--) {
                    if (x.charAt(i) == y.charAt(j) && x.charAt(i) == z.charAt(k)) {
                        dp[i][j][k] = dp[i + 1][j + 1][k + 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i + 1][j][k], Math.max(dp[i][j + 1][k], dp[i][j][k + 1]));
                    }
                }
            }
        }

        char[] ans = new char[dp[0][0][0]];
        int i = 0, j = 0, k = 0, pos = 0;
        while (i < m && j < n && k < p) {
            if (x.charAt(i) == y.charAt(j) && x.charAt(i) == z.charAt(k)) {
                ans[pos++] = x.charAt(i);
                i++;
                j++;
                k++;
            } else if (dp[i + 1][j][k] >= dp[i][j + 1][k]) {
                if (dp[i + 1][j][k] >= dp[i][j][k + 1]) i++;
                else k++;
            } else {
                if (dp[i][j + 1][k] >= dp[i][j][k + 1]) j++;
                else k++;
            }
        }
        return new String(ans);
    }


    public static int[][] longestCommonPrefixes(String s) {
        int n = s.length();
        int[][] lcp = new int[n][n + 1]; // cp[i][j] - length of common prefix, i>j
        for (int d = 1; d < n; d++) {
            for (int j = n - 1, i = j - d; i >= 0; i--, j--) {
                if (s.charAt(i) == s.charAt(j)) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }
        return lcp;
    }

    public static int[][] longestRepeatingPrefixes(int[][] lcp) {
        int n = lcp.length;
        int[][] lrs = new int[n + 1][n + 1]; // lrs[i][j] - how many times a[i:j] repeats
        for (int d = 1; d <= n / 2; d++) {
            for (int l3 = n, l2 = n - d, l1 = n - 2 * d; l1 >= 0; l3--, l2--, l1--) {
                if (lcp[l1][l2] >= d) lrs[l1][l2] = lrs[l2][l3] + 1;
            }
        }
        return lrs;
    }
}
