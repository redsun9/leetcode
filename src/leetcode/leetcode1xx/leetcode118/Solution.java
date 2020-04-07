package leetcode.leetcode1xx.leetcode118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(Collections.singletonList(1));
        List<Integer> prevRow = ans.get(0);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            prevRow = row;
            ans.add(row);
        }
        return ans;
    }
}
