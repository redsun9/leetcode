package leetcode.leetcode25xx.leetcode2525;

public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = length >= 10_000 || width >= 10_000 || height >= 10_000
                || 1_000_000_000 / length / width / height == 0
                || length * width * height >= 1_000_000_000;
        boolean heavy = mass >= 100;

        if (bulky && heavy) return "Both";
        if (bulky) return "Bulky";
        if (heavy) return "Heavy";
        return "Neither";
    }
}
