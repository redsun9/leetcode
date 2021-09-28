package leetcode.leetcode2xx.leetcode256;

public class Solution {
    public int minCost(int[][] costs) {
        int prevA = 0, prevB = 0, prevC = 0, nextA, nextB, nextC;
        for (int[] cost : costs) {
            nextA = Math.min(prevB, prevC) + cost[0];
            nextB = Math.min(prevA, prevC) + cost[1];
            nextC = Math.min(prevA, prevB) + cost[2];
            prevA = nextA;
            prevB = nextB;
            prevC = nextC;
        }
        return Math.min(prevA, Math.min(prevB, prevC));
    }
}
