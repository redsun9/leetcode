package leetcode.leetcode5xx.leetcode598;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            if (op[0] != 0 && op[1] != 0) {
                m = Math.min(m, op[0]);
                n = Math.min(n, op[1]);
            }
        }
        return m * n;
    }
}
