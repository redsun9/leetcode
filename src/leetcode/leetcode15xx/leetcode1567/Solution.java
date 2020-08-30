package leetcode.leetcode15xx.leetcode1567;

public class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int firstNeg = -1, lastNeg = -1, start = 0;
        boolean positive = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (nums[i] < 0) {
                    if (firstNeg == -1) firstNeg = i;
                    lastNeg = i;
                    positive = !positive;
                }
            } else {
                if (positive) ans = Math.max(ans, i - start);
                else ans = Math.max(ans, Math.max(i - firstNeg - 1, lastNeg - start));
                firstNeg = -1;
                positive = true;
                start = i + 1;
            }
        }
        if (positive) ans = Math.max(ans, n - start);
        else ans = Math.max(ans, Math.max(n - firstNeg - 1, lastNeg - start));
        return ans;
    }
}
