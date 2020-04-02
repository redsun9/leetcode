package leetcode.leetcode13xx.leetcode1380;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        LinkedList<Integer> ans = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowIndex = new int[m];

        for (int i = 0; i < m; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            int[] ints = matrix[i];
            for (int i1 = 0, intsLength = ints.length; i1 < intsLength; i1++) {
                int num = ints[i1];
                if (num < minValue) {
                    minValue = num;
                    minIndex = i1;
                }
            }
            rowIndex[i] = minIndex;
        }

        for (int j = 0; j < n; j++) {
            int maxValue = 0;
            int maxIndex = 0;
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                if (num > maxValue) {
                    maxValue = num;
                    maxIndex = i;
                }
            }
            if (rowIndex[maxIndex] == j) ans.add(maxValue);
        }
        return ans;
    }
}
