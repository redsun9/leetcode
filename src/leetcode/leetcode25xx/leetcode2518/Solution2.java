package leetcode.leetcode25xx.leetcode2518;

public class Solution2 {
    private static final int p = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int[][] cache = new int[n + 1][k + 1];
        return dfs(0, n, 0, 0, nums, k, cache);
    }

    private static int dfs(int i, int n, int l, int r, int[] nums, int k, int[][] cache) {
        if (l >= k && r >= k) return powMod2(n - i);
        if (i == n) return 0;
        l = Math.min(l, k);
        r = Math.min(r, k);
        int min = Math.min(l, r);
        if (cache[i][min] == 0) {
            int ans = dfs(i + 1, n, l + nums[i], r, nums, k, cache) + dfs(i + 1, n, l, r + nums[i], nums, k, cache);
            if (ans >= p) ans -= p;
            cache[i][min] = ans + 1;
        }
        return cache[i][min] - 1;
    }


    public static int powMod2(int n) {
        int a = 2;
        long res = 1;
        while (n != 0)
            if ((n & 1) != 0) {
                res = (res * a) % p;
                --n;
            } else {
                a = (int) (((long) a * a) % p);
                n >>= 1;
            }
        return (int) res;
    }
}
