package ege;

public class Problem19 {
    public static void main(String[] args) {
        int[][] dp = new int[1000][1000];
        int a = 10;
        for (int i = 1; i < 100; i++) {
            if (dfs(a, i, dp) && (dfs(a + 1, i, dp) || dfs(a * 2, i, dp) || dfs(a, i + 1, dp) || dfs(a, i * 2, dp))) {
                System.out.println(i);
            }
        }
    }


    private static boolean dfs(int a, int b, int[][] dp) {
        if (a >= 61 || b >= 61) return false;
        if (dp[a][b] == 0) {
            boolean c = !dfs(a + 1, b, dp) || !dfs(a, b + 1, dp) || !dfs(a * 2, b, dp) || !dfs(a, b * 2, dp);
            dp[a][b] = c ? 1 : 2;
        }
        return dp[a][b] == 1;
    }
}
