package leetcode.leetcode2xx.leetcode215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k + 1;
        int pivot;
        while (true) {
            pivot = partition(nums, lo, hi);
            if (pivot + 1 == k) break;
            if (pivot + 1 < k) lo = pivot + 1;
            else hi = pivot - 1;
        }
        return nums[pivot];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int start = lo;
        while (lo < hi) {
            if (nums[lo] < pivot) swap(nums, start++, lo);
            lo++;
        }
        swap(nums, start, hi);
        return start;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
