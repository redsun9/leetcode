package leetcode.leetcode7xx.leetcode719;

import java.util.Arrays;

public class Solution2 {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            lo = Math.min(lo, nums[i] - nums[i - 1]);
        }
        int hi = nums[n - 1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int[] val = countPairs(nums, mid);
            if (val[0] >= k && val[1] != 0 && k > val[0] - val[1]) return mid;
            if (val[0] >= k) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    public static int[] countPairs(int[] nums, int target) {
        int left = 0;
        int count1 = 0, count2 = 0; //count1 - number of less or equal, count2 - number of equals
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[left] > target) left++;
            count1 += i - left;
            int left2 = left;
            while (left2 < i && nums[i] - nums[left2] == target) left2++;
            count2 += left2 - left;
        }
        return new int[]{count1, count2};
    }
}
