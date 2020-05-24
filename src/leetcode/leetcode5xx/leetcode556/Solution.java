package leetcode.leetcode5xx.leetcode556;

public class Solution {
    public int nextGreaterElement(int n) {
        int[] digits = new int[10];
        int digitCounter = 0;
        int tmp = n;
        while (digitCounter == 0 || tmp != 0) {
            digits[digitCounter++] = tmp % 10;
            tmp /= 10;
        }
        reverse(digits, 0, digitCounter - 1);
        if (nextPermutation(digits, digitCounter)) {
            long ans = 0;
            for (int i = 0; i < digitCounter; i++) {
                ans = ans * 10 + digits[i];
            }
            return ans <= Integer.MAX_VALUE ? (int) ans : -1;
        } else return -1;
    }

    private static boolean nextPermutation(int[] nums, int n) {
        int k = n - 2;
        for (; k >= 0; k--) if (nums[k] < nums[k + 1]) break;

        if (k < 0) {
            return false;
        } else {
            int l = n - 1;
            for (; l > k + 1; l--) if (nums[k] < nums[l]) break;
            swap(nums, k, l);
            reverse(nums, k + 1, n - 1);
            return true;
        }
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) swap(nums, from++, to--);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
