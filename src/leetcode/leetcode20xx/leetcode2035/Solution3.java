package leetcode.leetcode20xx.leetcode2035;

import java.util.Arrays;

public class Solution3 {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[0] - nums[1]);
        Arrays.sort(nums);
        return dfs(n, 0, (1 << n) - 1, nums);
    }

    private static int dfs(int n, int diff, int key, int[] nums) {
        if (key == 0) return Math.abs(diff);
        int highestOneBit = n - 1;
        while ((key >> highestOneBit & 1) == 0) highestOneBit--;
        key &= ~(1 << highestOneBit);

        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < highestOneBit; i++) {
            if ((key >> i & 1) == 1) {
                tmp = Math.min(tmp, dfs(highestOneBit, diff + nums[highestOneBit] - nums[i], key ^ (1 << i), nums));
                tmp = Math.min(tmp, dfs(highestOneBit, diff - nums[highestOneBit] + nums[i], key ^ (1 << i), nums));
            }
        }
        return tmp;
    }
}
