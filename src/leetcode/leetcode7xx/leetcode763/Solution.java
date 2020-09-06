package leetcode.leetcode7xx.leetcode763;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] left = new int[26];
        for (int i = 0; i < n; i++) left[s.charAt(i) - 'a'] = i;

        List<Integer> ans = new LinkedList<>();
        for (int i = 0, start = 0, curLeft = 0; i < n; i++) {
            curLeft = Math.max(curLeft, left[s.charAt(i) - 'a']);
            if (curLeft == i) {
                ans.add(i - start + 1);
                start = i + 1;
                curLeft = i + 1;
            }
        }
        return ans;
    }
}
