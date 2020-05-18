package leetcode.leetcode14xx.leetcode1453;

public class Solution {
    private static final double eps = 1e-10;

    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int maxDistBetweenPoints = 4 * r * r;
        int r2 = r * r;
        if (n <= 1) return n;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int dist = dx * dx +
                        dy * dy;
                if (maxDistBetweenPoints < dist) continue;
                if (maxDistBetweenPoints == dist) {
                    int x = (points[i][0] + points[j][0]) / 2;
                    int y = (points[i][1] + points[j][1]) / 2;
                    int count = 0;
                    for (int[] point : points) {
                        if ((point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y) <= r2) count++;
                    }
                    ans = Math.max(ans, count);
                } else {
                    double midx = (points[i][0] + points[j][0]) / 2.0;
                    double midy = (points[i][1] + points[j][1]) / 2.0;
                    double h = Math.sqrt(r2 - dist / 4.0);
                    double cos = dx / Math.sqrt(dist);
                    double sin = dy / Math.sqrt(dist);
                    double x1 = midx - sin * h;
                    double y1 = midy + cos * h;
                    int count = 0;
                    for (int[] point : points) {
                        if ((point[0] - x1) * (point[0] - x1) + (point[1] - y1) * (point[1] - y1) <= r2 + eps) count++;
                    }
                    ans = Math.max(ans, count);
                    double x2 = midx + sin * h;
                    double y2 = midy - cos * h;
                    count = 0;
                    for (int[] point : points) {
                        if ((point[0] - x2) * (point[0] - x2) + (point[1] - y2) * (point[1] - y2) <= r2 + eps) count++;
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }
}
