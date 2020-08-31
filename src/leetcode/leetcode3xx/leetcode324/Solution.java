package leetcode.leetcode3xx.leetcode324;

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int l = 0, r = n - 1, i = 0;
        while (i <= r) {
            if (nums[newIndex(i, n)] > median) swap(nums, newIndex(l++, n), newIndex(i++, n));
            else if (nums[newIndex(i, n)] < median) swap(nums, newIndex(r--, n), newIndex(i, n));
            else i++;
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
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
