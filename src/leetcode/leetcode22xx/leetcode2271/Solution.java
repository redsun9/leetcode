package leetcode.leetcode22xx.leetcode2271;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int n = tiles.length;

        int ans = 0;
        for (int i = 0, s = 0, l = 0; i < n; i++) {
            int r = tiles[i][1];
            int maxL = r - carpetLen + 1;
            s += tiles[i][1] - tiles[i][0] + 1;
            while (tiles[l][1] < maxL) {
                s -= (tiles[l][1] - tiles[l][0] + 1);
                l++;
            }
            //if left tile is covered partly, we need to lower the s
            int d = Math.max(0, maxL - tiles[l][0]);
            ans = Math.max(ans, s - d);
        }
        return ans;
    }
}
