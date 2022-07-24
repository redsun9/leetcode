package leetcode.leetcode23xx.leetcode2350;

public class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int n = rolls.length;
        if (n < k) return 1;

        // we use greedy algorithm, we want to use the most right first occurrence of some roll
        int ans = 1, cntLeft = k;
        int[] count = new int[k];
        for (int roll : rolls) {
            if (count[roll - 1] < ans) {
                count[roll - 1]++;
                cntLeft--;
                if (cntLeft == 0) {
                    ans++;
                    cntLeft = k;
                }
            }
        }
        return ans;
    }
}
