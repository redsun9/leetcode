package leetcode.leetcode22xx.leetcode2209;

public class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        if (n <= numCarpets * carpetLen) return 0;

        int[] whiteTiles = new int[n]; // arr[i] = how many white tiles in floor[i-carpetLen+1, i]
        int total = 0;
        for (int l = 0, r = 0, curr = 0; r < n; r++) {
            if (floor.charAt(r) == '1') {
                curr++;
                total++;
            }
            if (r - l == carpetLen) if (floor.charAt(l++) == '1') curr--;
            whiteTiles[r] = curr;
        }
        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        for (int i = 0; i < n; i++) prev[i + 1] = Math.max(prev[i], whiteTiles[i]);
        for (int k = 1, prevL = 0, prevR = carpetLen; k < numCarpets; k++, prevL = prevR, prevR += carpetLen) {
            System.arraycopy(prev, prevL + 1, next, prevL + 1, carpetLen);
            for (int i1 = prevL + 1, i2 = prevR; i2 < n; i1++, i2++) {
                next[i2 + 1] = Math.max(next[i2], prev[i1] + whiteTiles[i2]);
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return total - prev[n];
    }
}
