package leetcode.leetcode4xx.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) return points.length;
        Arrays.sort(points, Comparator.comparingInt(x -> x[1]));
        int ans = 1;
        int prevShot = points[0][1];
        for (int[] point : points) {
            if (point[0] > prevShot) {
                ans++;
                prevShot = point[1];
            }
        }
        return ans;
    }
}
