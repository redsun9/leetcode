package leetcode.leetcode1xx.leetcode134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        int start = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
