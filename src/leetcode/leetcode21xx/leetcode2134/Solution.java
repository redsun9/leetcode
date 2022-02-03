package leetcode.leetcode21xx.leetcode2134;

public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int num : nums) if (num == 1) k++;
        if (k <= 1 || k >= n - 1) return 0;

        int ans = k - 1, l = 0, r = 0, count = 0;
        while (l < n) {
            while (l < n && nums[l] == 0) l++;
            if (l == n) return ans;
            while (l + k > r) if (nums[(r++) % n] == 1) count++;
            ans = Math.min(ans, k - count);
            l++;
            count--;
        }
        return ans;
    }
}
