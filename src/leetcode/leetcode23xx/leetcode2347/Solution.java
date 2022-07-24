package leetcode.leetcode23xx.leetcode2347;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4])
            return "Flush";
        int[] count = new int[14];
        for (int rank : ranks) count[rank]++;
        int maxCount = 0;
        for (int a : count) maxCount = Math.max(maxCount, a);
        if (maxCount >= 3) return "Three of a Kind";
        if (maxCount == 2) return "Pair";
        else return "High Card";
    }
}
