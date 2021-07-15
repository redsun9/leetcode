package leetcode.leetcode6xx.leetcode611;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1, k = i + 2; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }
}
