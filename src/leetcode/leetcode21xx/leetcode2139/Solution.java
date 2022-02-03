package leetcode.leetcode21xx.leetcode2139;

public class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target > 3 && maxDoubles != 0) {
            if ((target & 1) == 0) {
                ans++;
                target >>= 1;
                maxDoubles--;
            } else {
                ans++;
                target--;
            }
        }
        return ans + (target - 1);
    }
}
