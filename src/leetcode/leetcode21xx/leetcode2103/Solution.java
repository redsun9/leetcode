package leetcode.leetcode21xx.leetcode2103;

public class Solution {
    private static final int numberOfRods = 10;

    public int countPoints(String rings) {
        int[] rods = new int[numberOfRods];
        int n = rings.length();

        for (int i = 0; i < n; i += 2) {
            int color = switch (rings.charAt(i)) {
                case 'R' -> 0;
                case 'G' -> 1;
                case 'B' -> 2;
                default -> throw new IllegalStateException("Unexpected value: " + rings.charAt(i));
            };
            int pos = rings.charAt(i + 1) - '0';
            rods[pos] |= 1 << color;
        }

        int ans = 0;
        for (int rod : rods) if (rod == 7) ans++;
        return ans;
    }
}
