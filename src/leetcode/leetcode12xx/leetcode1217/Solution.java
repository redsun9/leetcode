package leetcode.leetcode12xx.leetcode1217;

public class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int chip : chips) {
            if ((chip & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}
