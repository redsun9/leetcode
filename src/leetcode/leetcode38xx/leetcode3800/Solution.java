package leetcode.leetcode38xx.leetcode3800;

public class Solution {
    public long minimumCost(String s, String t, long flipCost, long swapCost, long crossCost) {
        int n = s.length();
        int count01 = 0, count10 = 0;
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (a == '0' && b == '1') count01++;
            else if (a == '1' && b == '0') count10++;
        }

        int diff = Math.max(count01, count10) - Math.min(count01, count10);
        long allFlips = (count01 + count10) * flipCost;

        long swapAsMost = Math.min(count01, count10) * swapCost;
        long remainingCost = Math.min(diff / 2 * (crossCost + swapCost) + diff % 2 * flipCost, diff * flipCost);
        return Math.min(allFlips, swapAsMost + remainingCost);
    }
}
