package leetcode.leetcode8xx.leetcode830;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = s.length();
        if (n < 3) return ans;
        int start = 0;
        char curChar = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c != curChar) {
                if (i - start >= 3) ans.add(List.of(start, i - 1));
                curChar = c;
                start = i;
            }
        }
        if (n - start >= 3) ans.add(List.of(start, n - 1));
        return ans;
    }
}
