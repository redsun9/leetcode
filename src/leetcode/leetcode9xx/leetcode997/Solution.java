package leetcode.leetcode9xx.leetcode997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n];
        for (int[] t : trust) {
            count[t[0] - 1]--;
            count[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == n - 1) return i + 1;
        }
        return -1;
    }
}
