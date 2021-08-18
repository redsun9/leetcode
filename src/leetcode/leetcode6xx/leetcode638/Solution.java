package leetcode.leetcode6xx.leetcode638;

import java.util.List;

public class Solution {
    public int shoppingOffers(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {
        int n = prices.size();
        int[] needPow = new int[n + 1];
        needPow[0] = 1;
        for (int i = 0; i < n; i++) needPow[i + 1] = needPow[i] * (needs.get(i) + 1);
        int totalNeed = needPow[n];
        int[] dp = new int[totalNeed];
        for (int key = 1; key < totalNeed; key++) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += prices.get(i) * (key % needPow[i + 1] / needPow[i]);
            dp[key] = sum;
        }
        for (List<Integer> special : specials) {
            int[] specialPow = new int[n + 1];
            boolean useful = true;
            specialPow[0] = 1;
            for (int i = 0; useful && i < n; i++) {
                useful = special.get(i) <= needs.get(i);
                specialPow[i + 1] = specialPow[i] * (needs.get(i) - special.get(i) + 1);
            }
            if (!useful) continue;
            int totalSpecial = specialPow[n];
            for (int key = 0; key < totalSpecial; key++) {
                int from = 0, to = 0;
                for (int i = 0; i < n; i++) {
                    int fromDigit = key % specialPow[i + 1] / specialPow[i];
                    int toDigit = fromDigit + special.get(i);
                    from += needPow[i] * fromDigit;
                    to += needPow[i] * toDigit;
                }
                dp[to] = Math.min(dp[to], dp[from] + special.get(n));
            }
        }
        return dp[totalNeed - 1];
    }
}
