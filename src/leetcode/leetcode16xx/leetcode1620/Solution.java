package leetcode.leetcode16xx.leetcode1620;

public class Solution {
    private final int MAX_VALUE = 50;

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] count = new int[MAX_VALUE + 1][MAX_VALUE + 1];
        for (int[] tower : towers) {
            int q = tower[2];
            int maxd = Math.min(radius, q - 1);
            int maxd2 = maxd * maxd;
            int x = tower[0], y = tower[1];
            for (int i = Math.max(0, x - maxd); i <= Math.min(MAX_VALUE, x + maxd); i++) {
                for (int j = Math.max(0, y - maxd); j <= Math.min(MAX_VALUE, y + maxd); j++) {
                    int d2 = (x - i) * (x - i) + (y - j) * (y - j);
                    if (d2 <= maxd2) count[i][j] += (int) (q / (1 + Math.sqrt(d2)));
                }
            }
        }
        int max = 0;
        int[] ans = {0, 0};
        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j <= MAX_VALUE; j++) {
                if (count[i][j] > max) {
                    max = count[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
