package leetcode.leetcode5xx.leetcode565;

public class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = 0, cnt, prv, nxt;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            prv = i;
            while (nums[prv] != -1) {
                nxt = nums[prv];
                nums[prv] = -1;
                prv = nxt;
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
