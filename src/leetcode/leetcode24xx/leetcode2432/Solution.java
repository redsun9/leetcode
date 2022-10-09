package leetcode.leetcode24xx.leetcode2432;

public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ans = 0, maxTime = 0, prevTime = 0;
        for (int[] log : logs) {
            int time = log[1] - prevTime;
            if (time > maxTime || time == maxTime && ans > log[0]) {
                maxTime = time;
                ans = log[0];
            }
            prevTime = log[1];
        }
        return ans;
    }
}
