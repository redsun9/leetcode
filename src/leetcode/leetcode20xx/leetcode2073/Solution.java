package leetcode.leetcode20xx.leetcode2073;

public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        if (tickets[k] == 1) return k + 1;
        int toBuy = tickets[k], ans = toBuy, n = tickets.length;
        for (int i = 0; i < k; i++) ans += Math.min(tickets[i], toBuy);
        toBuy--;
        for (int i = k + 1; i < n; i++) ans += Math.min(tickets[i], toBuy);
        return ans;
    }
}
