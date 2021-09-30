package leetcode.leetcode2xx.leetcode293;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        List<String> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != '+' || arr[i] != '+') continue;
            arr[i - 1] = '-';
            arr[i] = '-';
            ans.add(new String(arr));
            arr[i - 1] = '+';
            arr[i] = '+';
        }

        return ans;
    }
}
