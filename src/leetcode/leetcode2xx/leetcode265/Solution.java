package leetcode.leetcode2xx.leetcode265;

public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int k = costs[0].length;

        int prevMin = 0, prevMin2 = 0, prevColor = 0;

        for (int[] cost : costs) {
            int minCost = Integer.MAX_VALUE, minColor = -1,
                    minCost2 = Integer.MAX_VALUE, minColor2 = -1,
                    minCost3 = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                int c = cost[i];
                if (c < minCost3) {
                    if (c < minCost2) {
                        if (c < minCost) {
                            minCost3 = minCost2;
                            minCost2 = minCost;
                            minColor2 = minColor;
                            minCost = c;
                            minColor = i;
                        } else {
                            minCost3 = minCost2;
                            minCost2 = c;
                            minColor2 = i;
                        }
                    } else {
                        minCost3 = c;
                    }
                }
            }

            int nextMin, nextMin2, nextColor;
            if (prevColor != minColor) {
                nextMin = prevMin + minCost;
                nextColor = minColor;
                if (prevColor != minColor2) nextMin2 = prevMin + minCost2;
                else nextMin2 = Math.min(prevMin + minCost3, prevMin2 + minCost2);
            } else if (prevMin + minCost2 <= prevMin2 + minCost) {
                nextMin = prevMin + minCost2;
                nextColor = minColor2;
                nextMin2 = Math.min(prevMin2 + minCost, prevMin + minCost3);
            } else {
                nextMin = prevMin2 + minCost;
                nextColor = minColor;
                nextMin2 = prevMin + minCost2;
            }

            prevMin = nextMin;
            prevMin2 = nextMin2;
            prevColor = nextColor;
        }
        return prevMin;
    }
}
