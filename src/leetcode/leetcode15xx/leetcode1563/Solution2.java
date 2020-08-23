package leetcode.leetcode15xx.leetcode1563;

// wrong solution, only to show that greedy doesnt work
// counterexample - test8
public class Solution2 {
    private static int dfs(int i, int j, int[] presum, int[][] cache) {
        if (i == j) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        if (i + 1 == j) return Math.min(presum[i + 1] - presum[i], presum[i + 2] - presum[i + 1]);
        int middlePresum = presum[i] + presum[j + 1];
        int lo = i + 1, hi = j + 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int midValue = presum[mid] * 2;
            if (midValue == middlePresum) {
                lo = mid;
                break;
            } else if (midValue < middlePresum) lo = mid + 1;
            else hi = mid;
        }
        int pos = lo; //smallest index such that sum[i,pos-1]>=sum[pos,j]
        int ans;
        if (presum[pos] * 2 == middlePresum) {
            ans = presum[pos] - presum[i] + Math.max(
                    dfs(i, pos - 1, presum, cache),
                    dfs(pos, j, presum, cache)
            );
        } else {
            if (pos == i + 1) ans = presum[j + 1] - presum[pos] + dfs(pos, j, presum, cache);
            else if (pos == j + 1) ans = presum[j] - presum[i] + dfs(i, j - 1, presum, cache);
            else ans = Math.max(
                        presum[pos - 1] - presum[i] + dfs(i, pos - 2, presum, cache),
                        presum[j + 1] - presum[pos] + dfs(pos, j, presum, cache)
                );
        }
        cache[i][j] = ans;
//        System.out.println("i = " + i + ", j = " + j + ", ans = " + ans);
        return ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1) return 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) presum[i + 1] = presum[i] + stoneValue[i];
        int[][] cache = new int[n][n];
        return dfs(0, n - 1, presum, cache);
    }
}
