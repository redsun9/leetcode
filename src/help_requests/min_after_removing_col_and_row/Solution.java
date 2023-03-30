package help_requests.min_after_removing_col_and_row;

public class Solution {
    public static int minimumMaximumAfterRemovingSingleRowAndCol(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        if (m == 1 || n == 1) return 0;
        int[] point1 = maximumExcept(arr, -1, -1);
        int[] point2 = maximumExcept(arr, point1[0], point1[1]);

        int ans = arr[point2[0]][point2[1]];
        int[][] pointsToCheck = {{point1[0], point2[1]}, {point1[1], point2[0]}};
        for (int[] point : pointsToCheck) {
            int[] maxCoordinates = maximumExcept(arr, point[0], point[1]);
            ans = Math.min(ans, arr[maxCoordinates[0]][maxCoordinates[1]]);
        }
        return ans;
    }

    private static int[] maximumExcept(int[][] arr, int exceptI, int exceptJ) {
        int m = arr.length, n = arr[0].length;
        int i2 = 0, j2 = 0, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (i == exceptI) continue;
            for (int j = 0; j < n; j++) {
                if (j == exceptJ) continue;
                if (arr[i][j] > max2) {
                    i2 = i;
                    j2 = j;
                    max2 = arr[i][j];
                }
            }
        }
        return new int[]{i2, j2};
    }
}
