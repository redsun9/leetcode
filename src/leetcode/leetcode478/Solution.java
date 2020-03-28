package leetcode.leetcode478;

import java.util.Random;

public class Solution {
    private final double radius;
    private final double x0;
    private final double y0;
    private final Random random;

    public Solution(double radius, double x0, double y0) {
        this.radius = radius;
        this.x0 = x0;
        this.y0 = y0;
        this.random = new Random();
    }

    public double[] randPoint() {
        double r = radius * Math.sqrt(random.nextDouble());
        double phi = 2 * Math.PI * random.nextDouble();
        return new double[]{x0 + r * Math.cos(phi), y0 + r * Math.sin(phi)};
    }
}
