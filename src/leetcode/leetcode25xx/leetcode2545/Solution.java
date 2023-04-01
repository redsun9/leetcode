package leetcode.leetcode25xx.leetcode2545;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingInt(a -> -a[k]));
        return score;
    }
}
