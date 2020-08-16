package leetcode.leetcode11xx.leetcode1103;

public class Solution {
    public int[] distributeCandies(int c, int n) {
        int m = (int) ((Math.sqrt(8L * c + 1) - 1) / 2); //number of full givings
        int k = m / n; //number of full circles
        int d = m % n; //number of people with greater number of full givings

        int[] ans = new int[n];
        for (int i = 0; i < d; i++) {
            ans[i] = (k + 1) * (k * n + 2 * i + 2) / 2;
        }
        for (int i = d; i < n; i++) {
            ans[i] = k * ((k - 1) * n + 2 * i + 2) / 2;
        }
        ans[d] += c - m * (m + 1) / 2;
        return ans;
    }
}
