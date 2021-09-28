package leetcode.leetcode2xx.leetcode259;

import java.util.Arrays;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int threshold = target - nums[i];
            int j1 = i + 1, j2 = n - 1;
            while (j1 < j2) {
                while (j1 < j2 && nums[j1] + nums[j2] < threshold) j1++;
                ans += j1 - i - 1;
                j2--;
            }
            ans += (j2 - i) * (j2 - i - 1) / 2;
        }
        return ans;
    }
}
