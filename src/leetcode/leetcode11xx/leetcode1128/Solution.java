package leetcode.leetcode11xx.leetcode1128;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int hash = Math.max(a, b) * 10 + Math.min(a, b);
            ans += count[hash]++;
        }
        return ans;
    }
}
