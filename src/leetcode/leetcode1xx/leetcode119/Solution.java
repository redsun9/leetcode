package leetcode.leetcode1xx.leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);
        int prev = 1;
        for (int i = 0; i < rowIndex; i++) {
            prev = (int) ((long) prev * (rowIndex - i) / (i + 1));
            ans.add(prev);
        }
        return ans;
    }
}
