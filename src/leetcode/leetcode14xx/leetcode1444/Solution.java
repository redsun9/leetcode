package leetcode.leetcode14xx.leetcode1444;

public class Solution {
    private static final int p = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();

        //количество яблок в [i;m]x[j;n]
        int[][] c = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            char[] chars = pizza[i].toCharArray();
            for (int j = n - 1; j >= 0; j--) {
                c[i][j] = c[i + 1][j] + c[i][j + 1] - c[i + 1][j + 1] + (chars[j] == 'A' ? 1 : 0);
            }
        }

        if (c[0][0] < k) return 0;
        int[][] prev = new int[m][n];
        int[][] next = new int[m][n];
        prev[0][0] = 1;
        for (int nCut = 1; nCut < k; nCut++) {
            //сперва по строкам
            for (int i = 0; i < m; i++) {
                int tmp = 0;
                next[i][0] = 0;
                int tmp2 = prev[i][0];
                for (int j = 1; j < n; j++) {
                    if (c[i][j] < c[i][j - 1]) tmp = tmp2;
                    next[i][j] = tmp;
                    tmp2 = (tmp2 + prev[i][j]) % p;
                }
            }
            //теперь по столбцам
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                int tmp2 = prev[0][j];
                for (int i = 1; i < m; i++) {
                    if (c[i][j] < c[i - 1][j]) tmp = tmp2;
                    next[i][j] = (next[i][j] + tmp) % p;
                    tmp2 = (tmp2 + prev[i][j]) % p;
                }
            }
            int[][] t = prev;
            prev = next;
            next = t;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (c[i][j] != 0) ans += prev[i][j];
            }
        }
        return (int) (ans % p);
    }
}
