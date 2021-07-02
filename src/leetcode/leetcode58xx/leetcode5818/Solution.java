package leetcode.leetcode58xx.leetcode5818;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> longestCommomSubsequence(int[][] a) {
        List<Integer> ans = new ArrayList<>();
        int m = a.length;
        int[] pos = new int[m];
        int i = 0, from = -1, curr = 0;
        while (true) {
            if (i == from) {
                ans.add(curr);
                if (++pos[i] >= a[i].length) break;
                curr = a[i][pos[i]];
            }
            while (pos[i] < a[i].length && a[i][pos[i]] < curr) pos[i]++;
            if (pos[i] == a[i].length) break;
            if (a[i][pos[i]] > curr) {
                from = i;
                curr = a[i][pos[i]];
            }
            i++;
            if (i == m) i = 0;
        }
        return ans;
    }
}
