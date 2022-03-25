package leetcode.leetcode22xx.leetcode2212;

public class Solution {
    private static final int n = 11;
    private static final int totalVariants = 1 << n;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] costs = new int[totalVariants];
        int[] scores = new int[totalVariants];
        for (int i = 1, maxKey = 1; i <= n; i++, maxKey <<= 1) {
            int cost = aliceArrows[i] + 1;
            for (int from = 0, to = maxKey; from < maxKey; from++, to++) {
                costs[to] = costs[from] + cost;
                scores[to] = scores[from] + i;
            }
        }
        int max = 0, maxKey = 0;
        for (int i = 1; i < totalVariants; i++) {
            if (costs[i] <= numArrows && scores[i] >= max) {
                max = scores[i];
                maxKey = i;
            }
        }

        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) if ((maxKey >> i & 1) == 1) ans[i + 1] = aliceArrows[i + 1] + 1;
        ans[0] = numArrows - costs[maxKey];
        return ans;
    }
}
