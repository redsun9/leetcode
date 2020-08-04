package leetcode.leetcode15xx.leetcode1535;

public class Solution {
    public int getWinner(int[] arr, int k) {
        if (k == 1) return Math.max(arr[0], arr[1]);
        int wins = 0;
        int curMax = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (curMax < arr[i]) {
                curMax = arr[i];
                wins = 1;
            } else if (++wins == k) break;
        }
        return curMax;
    }
}
