package leetcode.leetcode16xx.leetcode1673;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        ans[0] = nums[0];
        int pos = 0;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            while (pos >= 0 && pos + n - i >= k && ans[pos] > num) pos--;
            if (pos != k - 1) ans[++pos] = num;
        }
        return ans;
    }
}
