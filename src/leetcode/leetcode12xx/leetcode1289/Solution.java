package leetcode.leetcode12xx.leetcode1289;

public class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int[] currentRow = arr[0];
        if (n == 1) return currentRow[0];
        int prevMin = 0;
        int prevMin2 = 0;
        int prevMinIndex = 0;
        for (int[] row : arr) {
            int curMin = row[0] + (prevMinIndex != 0 ? prevMin : prevMin2);
            int curMinIndex = 0;
            int curMin2 = row[1] + (prevMinIndex != 1 ? prevMin : prevMin2);
            if (curMin2 < curMin) {
                int t = curMin;
                curMin = curMin2;
                curMin2 = t;
                curMinIndex = 1;
            }
            for (int i = 2; i < n; i++) {
                int tmp = row[i] + (prevMinIndex != i ? prevMin : prevMin2);
                if (tmp < curMin2) {
                    if (tmp < curMin) {
                        curMin2 = curMin;
                        curMin = tmp;
                        curMinIndex = i;
                    } else {
                        curMin2 = tmp;
                    }
                }
            }
            prevMin = curMin;
            prevMin2 = curMin2;
            prevMinIndex = curMinIndex;
        }
        return prevMin;
    }
}
