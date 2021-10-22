package leetcode.leetcode20xx.leetcode2044;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int total = 0;
        for (int num : nums) total |= num;

        int n = nums.length;
        int ans = 0;
        for (int key = (1 << n) - 1; key != 0; key--) {
            int tmp = 0;
            for (int i = 0; i < n; i++) if ((key >>> i & 1) == 1) tmp |= nums[i];
            if (tmp == total) ans++;
        }
        return ans;
    }
}
