package leetcode.leetcode14xx.leetcode1423;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (n == k) {
            int tmp = 0;
            for (int point : cardPoints) {
                tmp += point;
            }
            return tmp;
        } else {
            int tmp = 0;
            for (int i = 0; i < k; i++) {
                tmp += cardPoints[i];
            }
            int ans = tmp;
            for (int i = k - 1, j = n - 1; i >= 0; i--, j--) {
                tmp = tmp + cardPoints[j] - cardPoints[i];
                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }
}
