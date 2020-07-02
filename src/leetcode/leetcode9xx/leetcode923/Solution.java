package leetcode.leetcode9xx.leetcode923;

public class Solution {
    public static final int mod = 1_000_000_007;

    public int threeSumMulti(int[] nums, int target) {
        long[] count = new long[101];
        for (int a : nums) count[a]++;
        long ans = 0;
        for (int i = 0, jk = target; i <= target / 3; i++, jk--) {
            long ci = count[i];
            if (ci == 0) continue;
            for (int j = Math.max(jk - 100, i), k = jk - j; j <= k; j++, k--) {
                long cj = count[j];
                long ck = count[k];
                if (cj == 0 || ck == 0) continue;
                if (i == j) {
                    if (j == k) ans += ci * (ci - 1) * (ci - 2) / 6;
                    else ans += ci * (ci - 1) / 2 * ck;
                } else {
                    if (j == k) ans += ci * cj * (cj - 1) / 2;
                    else ans += ci * cj * ck;
                }
            }
        }
        return (int) (ans % mod);
    }
}
