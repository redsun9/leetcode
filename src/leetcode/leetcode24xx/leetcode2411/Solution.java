package leetcode.leetcode24xx.leetcode2411;

public class Solution {
    private static final int NUMBER_OF_BITS = 30;

    public int[] smallestSubarrays(int[] nums) {
        int[] count = new int[NUMBER_OF_BITS];
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = n - 1, j = n - 1; i >= 0; i--) {
            moveLeft(count, nums[i]);
            while (j > i && canMoveRight(count, nums[j])) moveRight(count, nums[j--]);
            ans[i] = j - i + 1;
        }
        return ans;
    }

    private void moveRight(int[] count, int num) {
        for (int i = 0; i < NUMBER_OF_BITS; i++) count[i] -= num >> i & 1;
    }

    private boolean canMoveRight(int[] count, int num) {
        for (int i = 0; i < NUMBER_OF_BITS; i++) if (count[i] == 1 && (num >> i & 1) == 1) return false;
        return true;
    }

    private static void moveLeft(int[] count, int num) {
        for (int i = 0; i < NUMBER_OF_BITS; i++) count[i] += num >> i & 1;
    }
}
