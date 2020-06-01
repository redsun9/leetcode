package leetcode.leetcode14xx.leetcode1467;

public class Solution {
    private static final double[] fact = new double[100];

    static {
        fact[0] = 1;
        for (int i = 1; i < 100; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    public double getProbability(int[] balls) {
        int total = 0;
        double multiplier = 1;
        for (int ball : balls) {
            total += ball;
            multiplier *= fact[ball];
        }
        multiplier *= fact[total / 2] * fact[total / 2];
        return dfs(balls, 0, 0, 0, 0, 0, balls.length, multiplier, total) / fact[total];
    }

    private static double dfs(
            int[] balls, int total1, int total2, int color1, int color2,
            int pos, int n, double multiplier, int total
    ) {
        if (pos == n) {
            if (color1 == color2 && total1 == total2) return multiplier;
            else return 0;
        } else if (pos == n - 1) {
            int half = (total1 + total2 + balls[pos]) / 2;
            if (color1 == color2 && half > total1 && half > total2) {
                return multiplier / fact[half - total1] / fact[half - total2];
            } else if (color1 + 1 == color2 && total1 + balls[pos] == total2) {
                return multiplier / fact[balls[pos]];
            } else if (color1 == color2 + 1 && total2 + balls[pos] == total1) {
                return multiplier / fact[balls[pos]];
            } else return 0;
        } else {
            if (
                    total1 > total - total1 ||
                            total2 > total - total2 ||
                            color1 + n - pos < color2 ||
                            color2 + n - pos < color1
            ) return 0;
            double ans = 0;
            for (int i = balls[pos], j = 0; i >= 0; i--, j++) {
                ans += dfs(
                        balls, total1 + i, total2 + j,
                        color1 + (i != 0 ? 1 : 0), color2 + (j != 0 ? 1 : 0),
                        pos + 1, n, multiplier / fact[i] / fact[j], total
                );
            }
            return ans;
        }
    }
}
