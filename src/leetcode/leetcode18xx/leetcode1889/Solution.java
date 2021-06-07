package leetcode.leetcode18xx.leetcode1889;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int n = packages.length;
        long ans = Long.MAX_VALUE;
        long sumPackages = 0;
        for (int pack : packages) sumPackages += pack;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < packages[n - 1]) continue;
            int m = box.length;
            long temp = 0;
            int packed = 0, j = 0;
            while (j < m && packed != n && temp < ans) {
                int b = box[j++];
                int lo = packed;
                int hi = n;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (packages[mid] <= b) lo = mid + 1;
                    else hi = mid;
                }
                temp += ((long) b) * (lo - packed);
                packed = lo;
            }
            ans = Math.min(ans, temp);
        }
        return ans != Long.MAX_VALUE ? (int) ((ans - sumPackages) % p) : -1;
    }
}
