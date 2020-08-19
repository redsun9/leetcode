package leetcode.leetcode8xx.leetcode826;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) index[i] = i;
        Arrays.sort(index, Comparator.comparingInt(i -> difficulty[i]));

        int m = worker.length;
        Arrays.sort(worker);
        int ans = 0;
        int maxProfit = 0;
        int jobIndex = 0, workerIndex = 0;
        while (workerIndex < m) {
            int workerAbility = worker[workerIndex++];
            while (jobIndex < n && difficulty[index[jobIndex]] <= workerAbility) {
                maxProfit = Math.max(maxProfit, profit[index[jobIndex]]);
                jobIndex++;
            }
            ans += maxProfit;
        }
        return ans;
    }
}
