package leetcode.leetcode18xx.leetcode1859;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String sortSentence(String s) {
        char[] chars = s.toCharArray();
        List<int[]> list = new ArrayList<>();
        int n = s.length();
        for (int i = 0, left = 0; i < n; i++) {
            int c = chars[i] - '0';
            if (c >= 0 && c <= 9) {
                list.add(new int[]{left, i - left, c});
                left = i + 2;
            }
        }
        list.sort(Comparator.comparingInt(x -> x[2]));
        char[] ans = new char[n - list.size()];
        int pos = 0;
        for (int[] arr : list) {
            if (pos > 0) ans[pos - 1] = ' ';
            System.arraycopy(chars, arr[0], ans, pos, arr[1]);
            pos += arr[1] + 1;
        }
        return new String(ans);
    }
}
