package leetcode.leetcode9xx.leetcode991;

public class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            if ((target & 1) == 1) {
                ans++;
                target++;
            }
            ans++;
            target >>>= 1;
        }
        ans += startValue - target;
        return ans;
    }
}
