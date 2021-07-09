package leetcode.leetcode6xx.leetcode668;

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = n;
            for (int i = 1; i <= m; i++) {
                while (j >= 1 && i * j > mid) j--;
                count += j;
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
