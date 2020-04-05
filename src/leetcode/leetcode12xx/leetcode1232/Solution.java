package leetcode.leetcode12xx.leetcode1232;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int a = coordinates[0][1] - coordinates[1][1];
        int b = coordinates[1][0] - coordinates[0][0];
        int c = coordinates[1][0] * coordinates[0][1] - coordinates[0][0] * coordinates[1][1];

        for (int i = 2, n = coordinates.length; i < n; i++) {
            if (a * coordinates[i][0] + b * coordinates[i][1] != c) return false;
        }
        return true;
    }
}
