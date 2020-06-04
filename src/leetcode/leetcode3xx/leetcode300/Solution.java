package leetcode.leetcode3xx.leetcode300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            int lo = 0, hi = ans;
            while (lo != hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < v) lo = mid + 1;
                else hi = mid;
            }
            nums[lo] = v;
            if (lo == ans) ans++;
        }
        return ans;
    }
}
