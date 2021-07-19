package leetcode.leetcode18xx.leetcode1840;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        if (m == 0) return n - 1;
        Arrays.sort(restrictions, Comparator.comparingInt(x -> x[0]));
        int minInc = -1;
        for (int[] restriction : restrictions)
            if (restriction[1] - restriction[0] > minInc) restriction[1] = minInc + restriction[0];
            else minInc = restriction[1] - restriction[0];
        int minDec = Integer.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            int[] restriction = restrictions[i];
            if (restriction[1] + restriction[0] > minDec) restriction[1] = minDec - restriction[0];
            else minDec = restriction[1] + restriction[0];
        }

        int ans = Math.max(0, n - restrictions[m - 1][0] + restrictions[m - 1][1]);
        int prevI = 1, prevH = 0;
        for (int[] restriction : restrictions) {
            ans = Math.max(ans, (restriction[0] - prevI + restriction[1] + prevH) / 2);
            prevI = restriction[0];
            prevH = restriction[1];
        }
        return ans;
    }
}
