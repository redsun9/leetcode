package leetcode.leetcode24xx.leetcode2484;

public class Solution {
    public static final int p = 1_000_000_007;

    public int countPalindromes(String s) {
        int n = s.length();
        int[][] left1 = new int[n + 1][10], right1 = new int[n + 1][10];
        for (int i = 0; i < n; i++) {
            System.arraycopy(left1[i], 0, left1[i + 1], 0, 10);
            left1[i + 1][s.charAt(i) - '0']++;
        }
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(right1[i + 1], 0, right1[i], 0, 10);
            right1[i][s.charAt(i) - '0']++;
        }
        int[][][] left2 = new int[n + 1][10][10], right2 = new int[n + 1][10][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) System.arraycopy(left2[i][j], 0, left2[i + 1][j], 0, 10);
            int b = s.charAt(i) - '0';
            for (int a = 0; a < 10; a++) {
                left2[i + 1][a][b] += left1[i][a];
                if (left2[i + 1][a][b] >= p) left2[i + 1][a][b] -= p;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 10; j++) System.arraycopy(right2[i + 1][j], 0, right2[i][j], 0, 10);
            int b = s.charAt(i) - '0';
            for (int a = 0; a < 10; a++) {
                right2[i][a][b] += right1[i + 1][a];
                if (right2[i][a][b] >= p) right2[i][a][b] -= p;
            }
        }

        long ans = 0;
        for (int c = n - 3; c >= 2; c--) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    ans += (long) left2[c][i][j] * right2[c + 1][i][j];
                    if (ans >= p) ans %= p;
                }
            }
        }
        return (int) ans;
    }
}
