package leetcode.leetcode15xx.leetcode1515;

import java.util.Random;


/*
    Geometric median
 */
public class Solution {
    private static final double eps = 1e-10;

    public double getMinDistSum(int[][] positions) {
        Random random = new Random();
        double prevX = random.nextDouble();
        double prevY = random.nextDouble();

        while (true) {
            double nextX = 0, nextY = 0, weight = 0;
            for (int[] position : positions) {
                double d = Math.hypot(prevX - position[0], prevY - position[1]);
                if (d < eps) return getSumDistance(positions, prevX, prevY);
                nextX += position[0] / d;
                nextY += position[1] / d;
                weight += 1 / d;
            }
            nextX /= weight;
            nextY /= weight;
            if (Math.hypot(nextX - prevX, nextY - prevY) < eps) {
                return getSumDistance(positions, nextX, nextY);
            }
            prevX = nextX;
            prevY = nextY;
        }
    }

    private static double getSumDistance(int[][] positions, double x, double y) {
        double ans = 0;
        for (int[] position : positions) {
            ans += Math.hypot(x - position[0], y - position[1]);
        }
        return ans;
    }
}
