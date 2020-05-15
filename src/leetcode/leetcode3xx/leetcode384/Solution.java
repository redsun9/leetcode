package leetcode.leetcode3xx.leetcode384;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private final int n;
    private final Random random;
    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] ans = Arrays.copyOf(nums, n);
        for (int i = n; i > 1; ) {
            int j = random.nextInt(i--);
            if (i != j) {
                int t = ans[i];
                ans[i] = ans[j];
                ans[j] = t;
            }
        }
        return ans;
    }
}
