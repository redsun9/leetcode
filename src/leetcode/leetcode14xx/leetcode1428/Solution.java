package leetcode.leetcode14xx.leetcode1428;

import java.util.List;

public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);
        int ans = n;
        while (ans > 0 && m > 0) {
            m--;
            int lo = 0;
            int hi = ans - 1;
            if (binaryMatrix.get(m, hi) == 0) continue;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (binaryMatrix.get(m, mid) == 0) lo = mid + 1;
                else hi = mid;
            }
            ans = lo;
        }
        return ans < n ? ans : -1;
    }
}
