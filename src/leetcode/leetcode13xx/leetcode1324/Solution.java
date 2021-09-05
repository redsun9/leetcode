package leetcode.leetcode13xx.leetcode1324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> printVertically(String s) {
        String[] parts = s.split(" ");
        int n = parts.length;
        int m = 0;
        for (String part : parts) m = Math.max(m, part.length());

        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(arr[i], ' ');

        int[] pos = new int[m];
        for (int j = 0; j < n; j++) {
            String part = parts[j];
            int len = part.length();
            for (int i = 0; i < len; i++) {
                arr[i][j] = part.charAt(i);
                pos[i] = j + 1;
            }
        }

        List<String> ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) ans.add(new String(arr[i], 0, pos[i]));
        return ans;
    }
}
