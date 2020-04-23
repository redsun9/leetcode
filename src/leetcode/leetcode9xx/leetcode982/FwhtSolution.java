package leetcode.leetcode9xx.leetcode982;

public class FwhtSolution {
    public int countTriplets(int[] nums) {
        int n = 1 << 16;
        int[] ans = new int[n];
        for (int num : nums) ans[num]++;
        fwht(ans, false);
        for (int i = 0; i < n; i++) ans[i] = ans[i] * ans[i] * ans[i];
        fwht(ans, true);
        return ans[0];
    }

    private static void fwht(int[] a, boolean inv) {
        int n = a.length;
        for (int m = 1; 2 * m <= n; m *= 2) {
            for (int i = 0; i < n; i += 2 * m) {
                for (int j = 0; j < m; ++j) {
                    int x = a[i + j];
                    int y = a[i + j + m];
                    if (inv) {
                        a[i + j] = -x + y;
                        a[i + j + m] = x;
                    } else {
                        a[i + j] = y;
                        a[i + j + m] = x + y;
                    }
                }
            }
        }
    }
}
