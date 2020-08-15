package leetcode.leetcode8xx.leetcode812;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, Math.abs(
                            (points[j][0] - points[i][0]) * (points[k][1] - points[i][1]) -
                                    (points[j][1] - points[i][1]) * (points[k][0] - points[i][0])
                    ));
                }
            }
        }
        return ans / 2.0;
    }
}
