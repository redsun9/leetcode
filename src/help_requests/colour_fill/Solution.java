package help_requests.colour_fill;

// DFS solution
// O(m*n) - time, O(m*n) - space
public class Solution {
    public static int numberOfFills(int[][] mat) {
        int ans = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    dfs(mat, i, j, m, n, mat[i][j]);
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] mat, int i, int j, int m, int n, int colour) {
        if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] != colour) return;
        mat[i][j] = 0;
        dfs(mat, i + 1, j, m, n, colour);
        dfs(mat, i - 1, j, m, n, colour);
        dfs(mat, i, j + 1, m, n, colour);
        dfs(mat, i, j - 1, m, n, colour);
    }
}
