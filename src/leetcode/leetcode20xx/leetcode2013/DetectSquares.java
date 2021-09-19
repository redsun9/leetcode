package leetcode.leetcode20xx.leetcode2013;

public class DetectSquares {
    private static final int MAX_COORD = 1000;
    private final int[][] count = new int[MAX_COORD + 1][MAX_COORD + 1];


    public void add(int[] point) {
        count[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int ans = 0, x1 = point[0], y1 = point[1];

        int threshold = x1 + Math.min(MAX_COORD - x1, MAX_COORD - y1);
        for (int x2 = x1 + 1, y2 = y1 + 1; x2 <= threshold; ++x2, ++y2) {
            ans += count[x1][y2] * count[x2][y1] * count[x2][y2];
        }

        threshold = x1 + Math.min(MAX_COORD - x1, y1);
        for (int x2 = x1 + 1, y2 = y1 - 1; x2 <= threshold; ++x2, --y2) {
            ans += count[x1][y2] * count[x2][y1] * count[x2][y2];
        }

        threshold = x1 - Math.min(x1, MAX_COORD - y1);
        for (int x2 = x1 - 1, y2 = y1 + 1; x2 >= threshold; --x2, ++y2) {
            ans += count[x1][y2] * count[x2][y1] * count[x2][y2];
        }

        threshold = x1 - Math.min(x1, y1);
        for (int x2 = x1 - 1, y2 = y1 - 1; x2 >= threshold; --x2, --y2) {
            ans += count[x1][y2] * count[x2][y1] * count[x2][y2];
        }
        return ans;
    }
}
