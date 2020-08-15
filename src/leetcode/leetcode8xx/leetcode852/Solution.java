package leetcode.leetcode8xx.leetcode852;

public class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (true) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
            if (a[mid] < a[mid - 1]) hi = mid;
            else lo = mid;
        }
    }
}
