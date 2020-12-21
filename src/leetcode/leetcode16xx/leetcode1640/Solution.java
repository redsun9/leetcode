package leetcode.leetcode16xx.leetcode1640;

import java.util.HashMap;

public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) map.put(pieces[i][0], i);
        int n = arr.length;
        int pos = 0;
        while (pos < n) {
            Integer index = map.get(arr[pos++]);
            if (index == null) return false;
            int[] piece = pieces[index];
            for (int i = 1; i < piece.length; i++) {
                if (arr[pos++] != piece[i]) return false;
            }
        }
        return true;
    }
}
