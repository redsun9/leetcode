package leetcode.leetcode15xx.leetcode1503;

public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int a : left) max = Math.max(max, a);
        int min = n;
        for (int a : right) min = Math.min(min, a);
        return Math.max(max, n - min);
    }
}
