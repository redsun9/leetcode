package leetcode.leetcode6xx.leetcode605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (n > (flowerbed.length + 1) / 2) return false;
        int s = 0;
        int start = -2; //previous 1
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (i - start >= 4) {
                    s += (i - start - 2) / 2;
                    if (s >= n) return true;
                }
                start = i;
            }
        }
        if (flowerbed.length - start >= 3) {
            s += (flowerbed.length - start - 1) / 2;
        }
        return s >= n;

    }
}
