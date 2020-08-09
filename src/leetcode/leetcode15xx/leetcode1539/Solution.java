package leetcode.leetcode15xx.leetcode1539;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || arr[0] > k) return k;
        if (arr[n - 1] < n + k) return n + k;
        int lo = 0;
        int hi = n - 2;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (arr[mid - 1] - mid >= k) hi = mid - 1;
            else lo = mid;
        }
        return lo + k;
    }
}
