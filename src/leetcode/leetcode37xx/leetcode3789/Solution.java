package leetcode.leetcode37xx.leetcode3789;

public class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        cost1 = Math.min(cost1, costBoth);
        cost2 = Math.min(cost2, costBoth);
        long a = (long) cost1 * need1 + (long) cost2 * need2;
        int needBoth = Math.min(need1, need2);
        long b = (long) needBoth * costBoth + (long) (need1 - needBoth) * cost1 + (long) (need2 - needBoth) * cost2;
        return Math.min(a, b);
    }
}
