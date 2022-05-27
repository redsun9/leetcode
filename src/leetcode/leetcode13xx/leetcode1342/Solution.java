package leetcode.leetcode13xx.leetcode1342;

public class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num & 1;
            num &= ~1;
            if (num != 0) {
                ans++;
                num >>= 1;
            }
        }
        return ans;
    }
}
