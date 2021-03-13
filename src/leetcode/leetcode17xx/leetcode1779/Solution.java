package leetcode.leetcode17xx.leetcode1779;

public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int tmp = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (tmp < minDist) {
                    ans = i;
                    minDist = tmp;
                }
            }
        }
        return ans;
    }
}
