package leetcode.leetcode2xx.leetcode221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[] height = new int[n], square = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char[] row = matrix[i];
            int prevSquare = 0;
            int width = 0;
            for (int j = 0; j < n; j++) {
                width = row[j] == '1' ? width + 1 : 0;
                height[j] = row[j] == '1' ? height[j] + 1 : 0;
                int val = min(width, height[j], prevSquare + 1);
                ans = Math.max(ans, val);
                prevSquare = square[j];
                square[j] = val;
            }
        }
        return ans * ans;
    }

    private static int min(int a, int b, int c) {
        if (a <= b)
            if (a <= c) return a;
            else return c;
        else if (b <= c) return b;
        else return c;
    }
}
