package leetcode.leetcode7xx.leetcode795;

public class Solution {
    public int numSubarrayBoundedMax(int[] a, final int L, final int R) {
        int ans = 0;
        int n = a.length;
        int start = 0;
        boolean hasMax = false;
        int lastMax = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > R) {
                start = i + 1;
                hasMax = false;
                lastMax = i + 1;
            } else if (a[i] < L) {
                if (hasMax) {
                    ans += lastMax - start + 1;
                }
            } else {
                hasMax = true;
                lastMax = i;
                ans += i - start + 1;
            }
        }
        return ans;
    }
}
