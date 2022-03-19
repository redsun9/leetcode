package leetcode.leetcode21xx.leetcode2194;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0), r1 = s.charAt(1), c2 = s.charAt(3), r2 = s.charAt(4);
        List<String> ans = new ArrayList<>((r2 - r1 + 1) * (c2 - c1 + 1));
        for (char c = c1; c <= c2; c++) {
            for (char r = r1; r <= r2; r++) {
                ans.add(c + "" + r);
            }
        }
        return ans;
    }

}
