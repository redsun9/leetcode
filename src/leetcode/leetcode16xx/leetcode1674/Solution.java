package leetcode.leetcode16xx.leetcode1674;

public class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] exact = new int[2 * limit + 2];
        int[] oneMove = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
            exact[nums[i] + nums[j]]++;
            oneMove[Math.min(nums[i], nums[j]) + 1]++;
            oneMove[Math.max(nums[i], nums[j]) + limit + 1]--;
        }
        int ans = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            tmp += oneMove[i];
            ans = Math.min(n - tmp - exact[i], ans);
        }
        return ans;
    }
}
