package tinkoff.equilateral_triangles;

public class Solution2 {
    public static int solve(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    int d1 = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    int d2 = Math.abs(points[i][0] - points[k][0]) + Math.abs(points[i][1] - points[k][1]);
                    int d3 = Math.abs(points[j][0] - points[k][0]) + Math.abs(points[j][1] - points[k][1]);
                    if (d1 == d2 && d2 == d3) ans++;
                }
            }
        }
        return ans;
    }
}
