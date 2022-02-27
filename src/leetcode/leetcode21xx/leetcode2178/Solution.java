package leetcode.leetcode21xx.leetcode2178;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) != 0) return Collections.emptyList();
        finalSum >>= 1;
        long x = Math.round((Math.sqrt(8 * finalSum + 1) - 1) / 2);
        if (x * (x + 1) / 2 > finalSum) x--;

        List<Long> ans = new ArrayList<>((int) x);
        for (long i = 1; i < x; i++) ans.add(i << 1);
        finalSum <<= 1;
        ans.add(finalSum - x * (x - 1));
        return ans;
    }
}
