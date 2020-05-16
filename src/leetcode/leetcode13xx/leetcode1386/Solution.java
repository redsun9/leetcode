package leetcode.leetcode13xx.leetcode1386;

import java.util.HashMap;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Byte> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int r = seat[0];
            int c = seat[1];
            if (c >= 2 && c <= 9) {
                byte b = 0;
                if (c <= 5) b |= 1;
                if (c >= 4 && c <= 7) b |= 2;
                if (c >= 6) b |= 4;
                map.merge(r, b, (a1, a2) -> (byte) (a1 | a2));
            }
        }
        int ans = (n - map.size()) * 2;
        for (byte b : map.values()) {
            if (b != 7) ans += 1;
        }
        return ans;
    }
}
