package leetcode.leetcode5xx.leetcode517;

public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int machine : machines) sum += machine;
        if (sum % n != 0) return -1;
        int avg = sum / n;
        int maxDiff = 0, maxFlow = 0;
        int current = 0;
        for (int machine : machines) {
            current += machine - avg;
            maxDiff = Math.max(maxDiff, machine - avg);
            maxFlow = Math.max(maxFlow, Math.abs(current));
        }
        return Math.max(maxDiff, maxFlow);
    }
}
