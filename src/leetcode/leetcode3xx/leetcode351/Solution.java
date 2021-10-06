package leetcode.leetcode3xx.leetcode351;

import java.util.Arrays;

public class Solution {
    private static final int[] pref = {0, 9, 65, 385, 2009, 9161, 35177, 108089, 248793, 389497};

    public int numberOfPatterns(int m, int n) {
        return pref[n] - pref[m - 1];
    }

    public static void main(String[] args) {
        int[] count = new int[10];
        for (int i = 0; i < 9; i++) dfs(i, 1 << i, 1, count);
        for (int i = 0; i < 9; i++) count[i + 1] += count[i];
        System.out.println(Arrays.toString(count));
    }

    private static void dfs(int i, int used, int len, int[] count) {
        count[len]++;
        if (len == 9) return;
        for (int j = 0; j < 9; j++) {
            if (
                    (used >> j & 1) == 0 &&
                            (i + j != 8 || (used >> 4 & 1) == 1) &&
                            (i % 3 != j % 3 || i / 3 == 1 || j / 3 == 1 || ((used >> ((i + j) / 2)) & 1) == 1) &&
                            (i / 3 != j / 3 || i % 3 == 1 || j % 3 == 1 || ((used >> ((i + j) / 2)) & 1) == 1)
            ) {
                dfs(j, used | 1 << j, len + 1, count);
            }
        }
    }
}
