package leetcode.leetcode22xx.leetcode2240;

public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int a = Math.max(cost1, cost2), b = Math.min(cost1, cost2);
        long ans = 0;
        while (total >= 0) {
            ans += (total / b + 1);
            total -= a;
        }
        return ans;
    }
}
