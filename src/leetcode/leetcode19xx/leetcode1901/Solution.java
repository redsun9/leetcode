package leetcode.leetcode19xx.leetcode1901;

public class Solution {
    private static int[] horizontalCuts(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int lo = 0, hi = m - 1;
        while (hi - lo > 2) {
            int mid = (lo + hi) / 2;
            int maxL = -1, maxR = -1, maxC = -1, maxPosC = 0;
            for (int j = 0; j < n; j++) {
                maxL = Math.max(maxL, mat[mid - 1][j]);
                maxR = Math.max(maxR, mat[mid + 1][j]);
                if (mat[mid][j] > maxC) {
                    maxC = mat[mid][j];
                    maxPosC = j;
                }
            }
            if (maxC >= maxL && maxC >= maxR) return new int[]{mid, maxPosC};
            if (maxL >= maxR) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int max = -1;
        int[] ans = {0, 0};
        for (int i = lo; i <= hi; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > max) {
                    ans[0] = i;
                    ans[1] = j;
                    max = mat[i][j];
                }
            }
        }
        return ans;
    }

    private static int[] verticalCuts(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int lo = 0, hi = m - 1;
        while (hi - lo > 2) {
            int mid = (lo + hi) / 2;
            int maxL = -1, maxR = -1, maxC = -1, maxPosC = 0;
            for (int i = 0; i < n; i++) {
                maxL = Math.max(maxL, mat[i][mid - 1]);
                maxR = Math.max(maxR, mat[i][mid + 1]);
                if (mat[i][mid] > maxC) {
                    maxC = mat[i][mid];
                    maxPosC = i;
                }
            }
            if (maxC >= maxL && maxC >= maxR) return new int[]{maxPosC, mid};
            if (maxL >= maxR) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int max = -1;
        int[] ans = {0, 0};
        for (int j = lo; j <= hi; j++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][j] > max) {
                    ans[0] = i;
                    ans[1] = j;
                    max = mat[i][j];
                }
            }
        }
        return ans;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (n > m) return verticalCuts(mat);
        else return horizontalCuts(mat);
    }
}
