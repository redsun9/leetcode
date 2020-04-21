package leetcode.leetcode2xx.leetcode216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final List<List<Integer>>[][] ans = new List[10][46];

    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 46; j++) {
                ans[i][j] = new LinkedList<>();
            }
        }
        for (int i = (1 << 9) - 1; i >= 0; i--) {
            int k = Integer.bitCount(i);
            int n = 0;
            List<Integer> subAns = new ArrayList<>(k);
            for (int j = 0; j < 9; j++) {
                if ((i & (1 << j)) != 0) {
                    subAns.add(j + 1);
                    n += j + 1;
                }
            }
            ans[k][n].add(subAns);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || k > 9 || n < 0 || n > 45) return Collections.emptyList();
        return ans[k][n];
    }
}
