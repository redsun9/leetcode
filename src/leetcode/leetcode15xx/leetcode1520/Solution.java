package leetcode.leetcode15xx.leetcode1520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(s);
        int[] left = new int[26], right = new int[26];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (left[i] == Integer.MAX_VALUE) continue;
            int l = left[i];
            int r = right[i];
            boolean valid = true;
            for (int j = l + 1; j < r; j++) {
                int c = s.charAt(j) - 'a';
                if (left[c] < l) {
                    valid = false;
                    break;
                }
                r = Math.max(r, right[c]);
            }
            if (valid) list.add(new int[]{l, r});
        }

        list.sort(Comparator.comparingInt(x -> x[1]));
        List<String> ans = new LinkedList<>();
        int end = -1;
        for (int[] range : list) {
            if (range[0] > end) {
                ans.add(s.substring(range[0], range[1] + 1));
                end = range[1];
            }
        }
        return ans;
    }
}
