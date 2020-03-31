package leetcode.leetcode10xx.leetcode1033;

import java.util.Arrays;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ints = {a, b, c};
        Arrays.sort(ints);
        int[] ans = new int[2];
        ans[1] = ints[2] - ints[0] - 2;
        ans[0] = 2;
        if (ints[1] - ints[0] <= 2 || ints[2] - ints[1] <= 2) ans[0] = 1;
        if (ints[2] - ints[0] == 2) ans[0] = 0;
        return ans;
    }
}
