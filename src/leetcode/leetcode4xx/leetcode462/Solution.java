package leetcode.leetcode4xx.leetcode462;

public class Solution {
    private static int findKthLargest(int[] nums, int k) {
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

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int ans = 0;
        for (int num : nums) ans += Math.abs(num - median);
        return ans;
    }
}
