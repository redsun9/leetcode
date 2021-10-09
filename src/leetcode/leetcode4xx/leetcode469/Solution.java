package leetcode.leetcode4xx.leetcode469;


public class Solution {
    /**
     * @param points: a list of two-tuples
     * @return a boolean, denote whether the polygon is convex
     */
    public boolean isConvex(int[][] points) {
        int n = points.length;
        if (n <= 2) return false;

        int a = area(points[n - 2], points[n - 1], points[0]);
        int b = area(points[n - 1], points[0], points[1]);

        boolean pos = a > 0 || b > 0;
        boolean neg = a < 0 || b < 0;

        int i = 0, j = 1, k = 2;
        while (k < n && (!pos || !neg)) {
            int c = area(points[i++], points[j++], points[k++]);
            pos |= c > 0;
            neg |= c < 0;
        }
        return pos ^ neg;
    }

    private static int area(int[] p1, int[] p2, int[] p3) {
        return (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);
    }

}
