package leetcode.leetcode12xx.leetcode1287;

public class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n < 4) return arr[0];
        int r = n / 4 + 1;
        for (int c = r - 1, lo = 0; c < n; c += r, lo += r) {
            int f = findFirstOccurrence(arr, arr[c], 0, c);
            if (f + r - 1 < n && arr[f + r - 1] == arr[c]) return arr[c];
        }
        return 0;
    }

    private static int findFirstOccurrence(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
