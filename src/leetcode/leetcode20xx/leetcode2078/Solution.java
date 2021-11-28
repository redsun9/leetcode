package leetcode.leetcode20xx.leetcode2078;

public class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i1 = 0, i2 = n - 1, color1 = colors[i1], color2 = colors[i2];
        while (colors[i1] == color2) i1++;
        while (colors[i2] == color1) i2--;
        return Math.max(n - 1 - i1, i2);
    }
}
