package leetcode.leetcode25xx.leetcode2511;

public class Solution {
    public int captureForts(int[] forts) {
        return Math.max(f(forts, 0, forts.length, 1), f(forts, forts.length - 1, -1, -1));
    }

    private static int f(int[] forts, int start, int end, int dx) {
        boolean canCapture = false;
        int currEnemy = 0, ans = 0;
        for (int i = start; i != end; i += dx) {
            if (forts[i] == 1) {
                canCapture = true;
                currEnemy = 0;
            } else if (forts[i] == -1) {
                ans = Math.max(ans, currEnemy);
                canCapture = false;
            } else {
                if (canCapture) currEnemy++;
            }
        }
        return ans;
    }
}
