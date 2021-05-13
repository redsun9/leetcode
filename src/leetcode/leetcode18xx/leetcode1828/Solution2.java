package leetcode.leetcode18xx.leetcode1828;

public class Solution2 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int count = 0;
            int r2 = query[2] * query[2];
            for (int[] point : points) {
                int x = query[0] - point[0];
                int y = query[1] - point[1];
                if (x * x + y * y <= r2) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
