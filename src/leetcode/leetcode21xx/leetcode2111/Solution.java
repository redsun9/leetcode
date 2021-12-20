package leetcode.leetcode21xx.leetcode2111;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0, n = arr.length;
        if (k >= n) return 0;

        for (int d = k - 1; d >= 0; d--) {
            int maxLen = 0;
            for (int i = d; i < n; i += k) {
                int v = arr[i];
                int lo = 0, hi = maxLen;
                while (lo != hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (arr[d + k * mid] <= v) lo = mid + 1;
                    else hi = mid;
                }
                arr[d + lo * k] = v;
                if (lo == maxLen) maxLen++;
            }
            ans += (n - d + k - 1) / k - maxLen;
        }
        return ans;
    }
}
