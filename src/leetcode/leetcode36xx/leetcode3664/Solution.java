package leetcode.leetcode36xx.leetcode3664;

import static java.lang.Math.max;

public class Solution {
    public int score(String[] cards, char x) {
        char minChar = 'a', maxChar = 'j';
        int k = maxChar - minChar + 1;

        int cntXX = 0;
        int[] cntAX = new int[k], cntXA = new int[k];
        for (String card : cards) {
            if (card.charAt(0) == x && card.charAt(1) == x) cntXX++;
            else if (card.charAt(0) == x) cntXA[card.charAt(1) - minChar]++;
            else if (card.charAt(1) == x) cntAX[card.charAt(0) - minChar]++;
        }
        int max1 = 0, sum1 = 0, max2 = 0, sum2 = 0;
        for (int i = 0; i < k; i++) {
            max1 = max(max1, cntXA[i]);
            sum1 += cntXA[i];
            max2 = max(max2, cntAX[i]);
            sum2 += cntAX[i];
        }

        int ans = 0;
        for (int a = 0, b = cntXX; b >= 0; a++, b--) {
            ans = max(ans, f(max(a, max1), sum1 + a) + f(max(b, max2), sum2 + b));
        }
        return ans;
    }

    private static int f(int max, int sum) {
        return max > sum - max ? sum - max : sum / 2;
    }
}
